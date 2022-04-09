import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CoachUI2 extends JFrame {
	private JTextField recipientText;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextArea messageText;
	private ArrayList<Member> membersList = new ArrayList<Member>();
	
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoachUI window = new CoachUI();
					window.this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public CoachUI2() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//this = new JFrame();
		this.setTitle("Coach Manager");
		this.setBounds(100, 100, 911, 727);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnShutdown = new JButton("Logout");
		toolBar.add(btnShutdown);
		ActionListener logoutListen = new logoutListener();
		btnShutdown.addActionListener(logoutListen);
		
		JTabbedPane coachTabs = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(coachTabs, BorderLayout.CENTER);
		
		JPanel coachMain = new JPanel();
		coachTabs.addTab("Main", null, coachMain, null);
		coachMain.setLayout(null);
		
		JScrollPane tableViewer = new JScrollPane();
		tableViewer.setBounds(330, 11, 553, 609);
		coachMain.add(tableViewer);
		
		JTextArea viewMemberListArea = new JTextArea();
		viewMemberListArea.setEditable(false);
		viewMemberListArea.setWrapStyleWord(true);
		tableViewer.setViewportView(viewMemberListArea);
		for (Member x: membersList){
		viewMemberListArea.append(viewMem(x));
		}
		
		JPanel sendMessages = new JPanel();
		sendMessages.setBorder(new TitledBorder(null, "Send Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sendMessages.setBounds(10, 416, 310, 204);
		coachMain.add(sendMessages);
		sendMessages.setLayout(null);
		
		JScrollPane messagePane = new JScrollPane();
		messagePane.setBounds(10, 50, 290, 106);
		sendMessages.add(messagePane);
		
		messageText = new JTextArea();
		messagePane.setViewportView(messageText);
		
		JLabel lblRecipient = new JLabel("Recipient:");
		lblRecipient.setBounds(88, 25, 74, 14);
		sendMessages.add(lblRecipient);
		
		recipientText = new JTextField();
		recipientText.setBounds(172, 22, 128, 20);
		sendMessages.add(recipientText);
		recipientText.setColumns(10);
		
		JButton btnSendMesssage = new JButton("Send");
		btnSendMesssage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendmsgtoMemtxt(recipientText.getText(), messageText.getText());
				recipientText.setText("");
				
			}
		});
		btnSendMesssage.setBounds(10, 167, 89, 23);
		sendMessages.add(btnSendMesssage);
		
		JButton btnCancelMessage = new JButton("Cancel");
		btnCancelMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recipientText.setText("");
				messageText.setText("");
			}
		});
		btnCancelMessage.setBounds(109, 167, 89, 23);
		sendMessages.add(btnCancelMessage);
		
		JPanel tableControls = new JPanel();
		tableControls.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Controls", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tableControls.setBounds(10, 12, 310, 394);
		coachMain.add(tableControls);
		tableControls.setLayout(null);
		
		JPanel addRemove = new JPanel();
		addRemove.setBorder(new TitledBorder(null, "Add/Remove", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addRemove.setBounds(10, 148, 290, 235);
		tableControls.add(addRemove);
		addRemove.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 31, 97, 14);
		addRemove.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 68, 97, 14);
		addRemove.add(lblLastName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 105, 97, 14);
		addRemove.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 142, 97, 14);
		addRemove.add(lblAddress);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(117, 28, 163, 20);
		addRemove.add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setColumns(10);
		txtLast.setBounds(117, 65, 163, 20);
		addRemove.add(txtLast);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(117, 102, 163, 20);
		addRemove.add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(117, 139, 163, 20);
		addRemove.add(txtAddress);
		
		//lastName,firstName,tele, address, bal,  paid, notPaid, consec, attend
		addMem("LN1", "FN1", "PHONE1", "ADDRESS1", 90, 3, 1, 1, 3);
		addMem("LN2", "FN2", "PHONE2", "ADDRESS2", 0, 4, 0, 3, 2);
		addMem("LN3", "FN3", "PHONE3", "ADDRESS3", -90, 5, 0, 1, 1);
		addMem("LN4", "FN4", "PHONE4", "ADDRESS4", 0, 3, 0, 1, 1);
		addMem("LN5", "FN5", "PHONE5", "ADDRESS5", 90, 4, 1, 1, 1);
		addMem("LN6", "FN6", "PHONE6", "ADDRESS6", -180, 7, 0, 2, 1);
		addMem("LN7", "FN7", "PHONE7", "ADDRESS7", 0, 2, 0, 1, 1);
		addMem("LN8", "FN8", "PHONE8", "ADDRESS8", 0, 1, 0, 2, 1);
		addMem("LN9", "FN9", "PHONE9", "ADDRESS9", 0, 4, 0, 1, 1);
		addMem("LN10", "FN10", "PHONE10", "ADDRESS10", 0, 1, 0, 1, 1);
		addMem("LN11", "FN11", "PHONE11", "ADDRESS11", 0, 2, 0, 1, 1);
		addMem("LN12", "FN12", "PHONE12", "ADDRESS12", 0, 3, 0, 1, 1);
		for (Member x: membersList){
			viewMemberListArea.append(viewMem(x));
			}
		
		JButton btnAddMem = new JButton("Add");
		btnAddMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMem(txtLast.getText(), txtFirst.getText(), txtPhone.getText(), txtAddress.getText());
				viewMemberListArea.setText("");
				for (Member x: membersList){
					viewMemberListArea.append(viewMem(x));
					}
			}
		});
		btnAddMem.setBounds(10, 170, 130, 23);
		addRemove.add(btnAddMem);
		
		JButton btnRemoveMem = new JButton("Remove");
		btnRemoveMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remMem(txtLast.getText(), txtFirst.getText());
				viewMemberListArea.setText("");
				for (Member x: membersList){
					viewMemberListArea.append(viewMem(x));
					}
			}
		});
		btnRemoveMem.setBounds(150, 170, 130, 23);
		addRemove.add(btnRemoveMem);
		
		JButton btnCancelMem = new JButton("Cancel");
		btnCancelMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLast.setText("");
				txtFirst.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		});
		btnCancelMem.setBounds(10, 201, 270, 23);
		addRemove.add(btnCancelMem);
		
		JButton btnSortFreq = new JButton("Sort via Frequency");
		btnSortFreq.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				sortAttendance();
				viewMemberListArea.setText("");
				for (Member x: membersList){
					viewMemberListArea.append(viewMem(x));
					}
			}
		});
		btnSortFreq.setBounds(10, 26, 290, 31);
		tableControls.add(btnSortFreq);
		
		JButton btnSortPay = new JButton("Sort via Payment");
		btnSortPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortPaid();
				viewMemberListArea.setText("");
				for (Member x: membersList){
					viewMemberListArea.append(viewMem(x));
					}
			}
		});
		btnSortPay.setBounds(10, 60, 290, 31);
		tableControls.add(btnSortPay);
		
		JButton btnApplyDiscountsfees = new JButton("Apply Discounts/Fees");
		btnApplyDiscountsfees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//do shit
				sortAttendance();
				for(Member x: membersList) {
				multipleMissedPay(x);
				consecDiscount(x);
				}
				topTen();
				viewMemberListArea.setText("");
				for (Member x: membersList){
					viewMemberListArea.append(viewMem(x));
				}
			}
		});
		btnApplyDiscountsfees.setBounds(10, 95, 290, 31);
		tableControls.add(btnApplyDiscountsfees);
		
		JPanel coachInbox = new JPanel();
		coachTabs.addTab("Inbox", null, coachInbox, null);
		coachInbox.setLayout(new BorderLayout(0, 0));
		
		JScrollPane coachInboxViewer = new JScrollPane();
		coachInbox.add(coachInboxViewer, BorderLayout.CENTER);
		
		JTextArea coachInboxText = new JTextArea();
		coachInboxText.setEditable(false);
		coachInboxViewer.setViewportView(coachInboxText);

		
	}
	class logoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame loWindow = new LoginUI();
			loWindow.setVisible(true);
			setVisible(false);
		}
	}
	
	public String viewMem(Member x){
		return x.getFirstName() + " " + x.getLastName() + " " + x.getTelephone() + " " + x.getAddress() + " bal: " + x.getBalance() + " Times Paid: " + x.getPaid() + " Missed Payments: " + x.getNotPaid() + "\n";
	}
	

	//
	public void addMem(String lastName, String firstName, String tele, String address){
		Member member = new Member(lastName, firstName, tele, address, 0, 0, 0, 0, 0);
		membersList.add(member);
	}
	public void addMem(String lastName, String firstName, String tele, String address, int bal, Integer paid, Integer notPaid, int consec, Integer attend){
		Member member = new Member(lastName, firstName, tele, address, bal, paid, notPaid, consec, attend);
		membersList.add(member);
	}
	
	public void remMem(String lastName, String firstName){
		membersList.remove(findMember(lastName, firstName));
	}	
	
	public Member findMember(String lastName, String firstName){
		for (Member x : membersList) {
			if ((x.getLastName().equals(lastName))&&(x.getFirstName().equals(firstName)))
				return x;
		}
		return null;
	}
	
	public void sortAttendance(){
		Collections.sort(membersList, new Comparator<Member>() {
			public int compare(Member firstMem, Member secondMem){
				return ((secondMem.getAttendance()).compareTo((firstMem.getAttendance())));
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
		if (mem.getNotPaid() > 1){
			mem.addBalance(10);
			//SEND MESSAGE TO PAY
		}
	}

	public void consecDiscount(Member mem){
		if (mem.getConsecDiscount() >= 3){
			mem.payBalance(5);
			//SEND MESSAGE 10% OFF RECEIVED FOR NEXT CLASS PURCHASED
		}
	}

	
	public void sendmsgtoMemtxt(String mem, String msg) {
		for(Member x : membersList) {
			if (mem.equals(x.getFirstName() + " " + x.getLastName())){
				writeToText(mem + "|" + msg+ "\n", "src/ui/membermsgs.txt");
				messageText.setText("");
				return;
			}
			else {
				messageText.setText("Member not found");
			}
		}
	}
	
	public void topTen(){
		for(int x=0;x<=9;x++){
			membersList.get(x).payBalance(5);
		}
	}
	
	public static void writeToText(String str, String output) {
	    try {
	        FileWriter filewrite = new FileWriter(output, true);
	        filewrite.write(str);
	        filewrite.close();
	    } catch (IOException e) {
	        System.out.println("Error");
	    }
	}
}
