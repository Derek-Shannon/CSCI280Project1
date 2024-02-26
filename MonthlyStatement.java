// CS-280
// Derek Shannon & Sydney Nilles
// Project 1
// 02/20/2024

// implementation progress: Mostly complete, still needs to be formatted with nice spacing in print statements

import java.util.ArrayList;

class MonthlyStatement{
    private String month; //Contains which month it is in numerical format to match the Transaction class.
    private ArrayList<Transaction> monthlyTransactions; //A list of all the transactions that occurred within a specified month.

    public MonthlyStatement(String month, ArrayList<Transaction> transactions){
        this.month = month;
        monthlyTransactions = new ArrayList<>();

        // double check ArrayList for the correct transactions for that month
        for (int i = 0; i < transactions.size(); i++){
            if ((transactions.get(i).getDate().contains(this.month))){
                monthlyTransactions.add(transactions.get(i));
            }
        }
    }

    /*
     * Writes and formats the transaction information for the customer to see.
     * Printed directly to console
     */
    public void arrangeStatement(){
        if (monthlyTransactions.size() < 1){
            System.out.println("**There are no transactions under this account.**");
            return;
        }
        String labels = String.format("%-10s %-45s %-10s %-10s","Type", "Purpose", "Amount", "Date");
        System.out.println(labels); // titles/labels
        for (Transaction t : monthlyTransactions){
            String line = String.format("%-10s %-45s %-10s %-10s", t.getType(), t.getMemo() ,t.getAmount(), t.getDate()); // the formatting of each line
            System.out.println(line);
        }
    }
}