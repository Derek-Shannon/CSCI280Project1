// CS-280
// Derek Shannon & Sydney Nilles
// Project 1
// 02/20/2024

// implementation progress: Mostly complete, still needs to be formatted with nice spacing in print statements

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
        String labels = String.format("%-10s %-50s %-10s %-10s","Type", "Purpose", "Amount", "Date");
        System.out.println(labels); // titles/labels

        for (Transaction t : monthlyTransactions){
            String line = String.format("%-10s %-45s %-10s %-10s", t.getType(), t.getMemo() ,t.getAmount(), t.getDate()); // the formatting of each line
            System.out.println(line);
        }
    }
}