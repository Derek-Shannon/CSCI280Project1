class Transaction{
    private String type; //Whether the transaction is a withdrawal, a deposit, or a transfer;
    private String memo; //Description of what the transaction was for, should the user be inclined to fill it out.
    private double amount; //the amount of moeny that was processed
    private String date; //the time the transaction was finalized

    // Constructor
    public Transaction(String type, String memo, double amount, String date){
        this.type = type;
        this.memo = memo;
        this.amount = amount;
        this.date = date;
    }

    // Overwriting the toString
    public String toString(){
        return "" + type + " $" + amount + " " + memo + " on " + date;
    }
}
