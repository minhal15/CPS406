public class Methods {
	
	ArrayList<Member> membersList = new ArrayList<Member>();
	private int totProfit;

			
	public void addMem(String userName, String password,  String lastName, String firstName, String tele, String email, String perm){
		Member member = new Member(userName, password, lastName, firstName, tele, email, perm, 0, 0, 0, 0, 0);
		membersList.add(member);
	}
	
	public void remMem(String lastName, String firstName){
		membersList.remove(findMember(lastName, firstName));
	}	
	
	public void remMem(String userName){
		membersList.remove(findMember(userName));
	}
	
	public Member findMember(String lastName, String firstName){
		for (Member x : membersList) {
			if ((x.getLastName().equals(lastName))&&(x.getFirstName().equals(firstName)))
				return x;
		}
		return null;
	}
	
	public Member findMember(String userName){
		for (Member x : membersList) {
			if (x.getUserName().equals(userName)){
				return x;
			}
		}
		return null;
	}
	
	public void addBal(Member mem, int bal){
		mem.addBalance(bal);
	}
	
	public void payBal(Member mem, int bal){
		mem.payBalance(bal);
	}
	
	public void attendedClass(Member mem, int numclass, String theClass){
		mem.classCounter(numclass);
		mem.classAttendance(theClass);
	}
	
	public String viewMem(){
		for (Member x: membersList){
			return x.getFirstName() + " " + x.getLastName() + " " + x.getBalance();
		}
		return null;
	}
	
	public void sortAttendance(){
		Collections.sort(membersList, new Comparator<Member>() {
			public int compare(Member firstMem, Member secondMem){
				return ((firstMem.getAttendance()).compareTo((secondMem.getAttendance())));
			}
		});
	}
	
	public void sortPaid(){
		Collections.sort(membersList, new Comparator<Member>() {
			public int compare(Member firstMem, Member secondMem){
				return firstMem.getPaid().compareTo(secondMem.getPaid());
			}
		});
	}

	public void sortNotPaid(){
		Collections.sort(membersList, new Comparator<Member>() {
			public int compare(Member firstMem, Member secondMem){
				return (firstMem.getNotPaid().compareTo(secondMem.getNotPaid()));
			}
		});
	}
	
	public void multipleMissedPay(Member mem){
		if (mem.getNotPaid() != 0){
			mem.addBalance(10);
			//SEND MESSAGE TO PAY
		}
	}
	
	public void consecDiscount(Member mem){
		if (mem.getConsecDiscount() > 3){
			mem.payBalance(5);
			//SEND MESSAGE 10% OFF RECEIVED FOR NEXT CLASS PURCHASED
		}
	}
	
	public Member whoIsAttendning(String currentClass){
		for (Member x : membersList) {
			if (x.isComing(currentClass))
				return x;
		}
		return null;
	}


	public void totalProfit(Member mem){
		for(Member x:membersList){
			totProfit += x.getPaid();
		}
	}


	public void topTen(){
		for(int x=0;x<=9;x++){
			membersList.get(i).payBalance(5);
		}
	}

	public Member advancePayment(){
		for(Member x : membersList){
			if (x.getBalance<0){
				return x;
			}
			return null;
		}
	}

	public String toString(Member mem){
		return mem.getFirstName() + " " + mem.getLastName() + ": " + getBalance();
	}
}
	

	


	class sendMsg implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sendmsgtoMem(recipientText.getText(),messageText.getText());
		}
	}
	public void sendmsgtoMem(String mem, String msg) {
		for(Member x : membersList) {
			if mem.equals(x.getFirstName() + " " + x.getLastName()){
				writeToText(mem + "|" + msg, membersmsgs.txt);
			}
			else
				messageText.setText("Member not found");
		}
	}
	public void setMessage(String file, String mem) {
		try {
	        BufferedReader buffread = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = buffread.readLine()) != null){
	        	String[] temp = line.split("|");
	        	if(temp[0].equals(mem)) {
	        		memInboxText.setText(temp[1], true);
	        	}
	        }
	        buffread.close();
	    } catch (IOException e) {
	        System.out.println("Could not find file");
	        return(""); //If the file cannot be found returns the empty string.
	    }	
	}