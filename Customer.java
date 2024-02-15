import java.util.ArrayList;

public class Customer{
    private String name; //name of the customer
    private ArrayList<Account> accounts; //list of accounts the user has


    public Customer(String name){
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    /* 
     * Shows the Customer's accounts in a neat way
    */
    public void viewAccounts(){
        
    }

    /*
     * Deletes an account with the given ID
     * @param the account to be deleted
     */
    public void deleteAccount(Account a1){
        a1 = null;
    }

    /*
     * Deletes an account with the given ID
     * @param ID number of the account to delete
     */
    public void addAccount(Account a1){
        accounts.add(a1);
    }
}