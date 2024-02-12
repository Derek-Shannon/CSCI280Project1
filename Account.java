import java.util.ArrayList;

class Account{
    private String name; //name of the account (checking/savings)
    private int id; //unique id for the account
    private double balance; //the total amount of money
    private ArrayList<Transaction> transactions; //list of every transaction the account has made

    /*
     * adds money to the account
     * @param amount to be added to the account
     */
    public void deposit(int amount){}

    /*
     * removes money from the account
     * @param amount to be added to the account
     */
    public void withdraw(int amount){}

    /*
     * checks to see if the balance is negative
     * @return true if the balance is negative and false if the balkance is positive
     */
    public boolean isNegative(){}

    /*
     * transfers money from the account to another account provide
     * @param recipient - the account that is recieveing the money
     * @param amount - the quantity of money being transfered to the other account
     */
    public void tranferTo(Account recipient, int amount){}

    /*
     * Prints organized text of all transactions from that account.
     */
    public void showStatment(){}
}