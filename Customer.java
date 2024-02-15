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
     * @param ID number of the account to delete
     */
    public void deleteAccount(int ID){

    }

    /*
     * Deletes an account with the given ID
     * @param ID number of the account to delete
     */
    public void addAccount(){

    }
}