import java.util.ArrayList;

class MonthlyStatement{
    private String month; //Contains which month it is in numerical format to match the Transaction class.
    private ArrayList<Transaction> monthlyTransactions; //A list of all the transactions that occurred within a specified month.

    public MonthlyStatement(String month, ArrayList<Transaction> monthlyTransactions){
        this.month = month;
        this.monthlyTransactions = monthlyTransactions;
    }

    /*
     * Writes and formats the transaction information for the customer to see.
     * Printed directly to console
     */
    public static void arrangeStatement(){
        
    }
}