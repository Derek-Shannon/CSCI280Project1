// CS-280
// Derek Shannon & Sydney Nilles
// Project 1
// 02/27/2024

import java.util.ArrayList;

class Account{
    private static ArrayList<Integer> idList = new ArrayList<Integer>(); //set of all ids for every account created
    private String name; //name of the account (checking/savings)
    private int id; //unique id for the account
    private double balance; //the total amount of money
    private ArrayList<Transaction> transactions; //list of every transaction the account has made

    public Account(String name){
        this.name = name;
        balance = 0;
        id = newID();
        idList.add(id);
        transactions = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void setName(String name){
        this.name = name;
    }
    /*
     * sets the account's id if given id doesn't exist
     * @param the id to change to
     */
    public void setID(int id){
        if (this.id == id){
            return;
        }
        for (int eachID : idList){
            if(eachID == id){
                id = newID();
            }
        }
        idList.remove(idList.indexOf(this.id));
        this.id = id;
        idList.add(this.id);
    }

    /*
     * creates a new random ID that hasn't been used yet
     * @return a new random id
     */
    private int newID(){
        int newIDNumber = -1;
        boolean run = true;
        while(run){
            newIDNumber = (int)(Math.random() * ((999999-100000) + 1));
            run = false;
            for(int eachID : idList){
                if(eachID == newIDNumber){
                    run = true;
                }
            }
        }
        return newIDNumber;
    }

    /*
     * adds money to the account
     * @param amount - to be added to the account
     * @param date - the date the deposit was attempted
     * @param memo - the message for what the deposit is for
     */
    public void deposit(double amount, String date, String memo){
        if(amount <0){
            System.out.println("**Value can't be negative**");
            return;
        }
        balance += amount;
        Transaction t1 = new Transaction("Deposit", memo, amount, date); //add to transaction log
        transactions.add(t1);
    }

    /*
     * removes money from the account
     * @param amount - to be added to the account
     * @param date - the date the withdraw was attempted
     * @param memo - the message for what the withdraw is for
     */
    public void withdraw(double amount, String date, String memo){
        if (balance < 0){
            System.out.println("**Not enough funds to withdraw**");
            return;
        }
        if(amount <0){
            System.out.println("**Value can't be negative**");
            return;
        }

        balance -= amount;
        Transaction t1 = new Transaction("Withdrawal", memo, amount, date); //add to transaction log
        transactions.add(t1);
        System.out.print("Transaction Complete! ");
        checkFee();
    }

    /*
     * checks to see if a fee needs to be added to the account
     */
    private void checkFee(){
        if (balance < 0){
            int fee = 18;
            //add transaction for fee
            balance -= fee;
            System.out.println("(Over Draft fee Added)");
        }
        else{
            System.out.println();
        }
    }

    /*
     * transfers money from the account to another account provide
     * @param recipient - the account that is recieveing the money
     * @param amount - the quantity of money being transfered to the other account
     * @param date - the date the transfer was attempted
     */
    public void tranferTo(Account recipient, double amount, String date){
        if (amount < 0){
            System.out.println("**Amount to send can't be negative**");
            return;
        }
        if (amount > balance){
            System.out.println("**Not enough funds to transfer**");
            return;
        }
        balance -= amount;
        checkFee();
        recipient.balance += amount;
        Transaction senderTransaction = new Transaction("Transfer", "Transfer to " + recipient.getName(), amount, date); //add to transaction log
        transactions.add(senderTransaction);
        Transaction recieverTransaction = new Transaction("Transfer", "Recieved from " + getName(), amount, date); //add to transaction log
        recipient.transactions.add(recieverTransaction);
        System.out.println("Transaction Complete! ");
    }

    /*
     * Prints organized text of all transactions from that account.
     */
    public void showStatement(){
        String labels = String.format("%-10s %-45s %-10s %-10s","Type", "Purpose", "Amount", "Date");
        System.out.println(labels); // titles/labels
        if (transactions.size() < 1){
            System.out.println("**There are no transactions under this account.**");
            return;
        }
        for (Transaction t : transactions){
            String line = String.format("%-10s %-45s %-10s %-10s", t.getType(), t.getMemo() ,t.getAmount(), t.getDate()); // the formatting of each line
            System.out.println(line);
        }
    }
}