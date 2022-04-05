public class Expense implements Comparable<Expense> {

    private int month;
    private int priority;
    private String type;
    private double amount;

    
    Expense(int month, int priority, String type, double amount) {
        this.month = month;
        this.priority = priority;
        this.type = type;
        this.amount = amount;
    }

    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }
    public int getPriority() {
        return priority;
    }

    public void setType(String newType) {
        this.type = newType;
    }
    public String getType() {
        return type;
    }

    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }
    public double getAmount() {
        return amount;
    }
    public int getMonth() {
        return month;
    }

    public int compareTo(Expense other) {
        if (this.month == other.getMonth()) {
            if (this.priority < other.getPriority()) return -1;
            if (this.priority > other.getPriority()) return +1;
            return 0;
        }
        else {
            if (this.month < other.getMonth()) return -1;
            if (this.month > other.getMonth()) return +1;
            return 0;
        }
    }

    public String monthToString(int month) {
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }
    public String toString(){
        return this.monthToString(this.getMonth())+" "+this.getPriority() + " " + this.getType() + " $" + this.getAmount()+"\n";
    }
}