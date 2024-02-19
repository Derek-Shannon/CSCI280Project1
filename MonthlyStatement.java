import java.util.ArrayList;

class MonthlyStatement{
    private String month; //Contains which month it is in numerical format to match the Transaction class.
    private ArrayList<Transaction> monthlyTransactions; //A list of all the transactions that occurred within a specified month.

    public MonthlyStatement(String month, ArrayList<Transaction> Transactions){
        this.month = month;
        this.monthlyTransactions = Transactions;

        // double check ArrayList for the correct transactions for that month
        for (Transaction t : this.monthlyTransactions){
            if ((t.getDate().contains(this.month))){
                this.monthlyTransactions.add(t);
            }
        }
    }

    /*
     * Writes and formats the transaction information for the customer to see.
     * Printed directly to console
     */
    public void arrangeStatement(){
        // needs to be properly configured
        System.out.println("Type Purpose Amount Date"); // titles/labels
        for (Transaction t : monthlyTransactions){
            // needs to be tested and properly configured
            String line = String.format("%10s %20s %40s %50s", t.getType(), t.getMemo() ,t.getAmount(), t.getDate()); // the formatting of each line
            System.out.println(line);
        }
    }
}