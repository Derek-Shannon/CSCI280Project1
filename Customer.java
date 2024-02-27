// CS-280
// Derek Shannon & Sydney Nilles
// Project 1
// 02/20/2024

import java.util.ArrayList;

public class Customer{
    private String name; //name of the customer
    private ArrayList<Account> accounts; //list of accounts the user has


    public Customer(String name){
        this.name = name;
        accounts = new ArrayList<Account>();
    }
    public String getName(){
        return name;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    /*
     * Deletes an account with the given ID
     * @param the account to be deleted
     */
    public void deleteAccount(Account a1){
        accounts.remove(a1);
        System.out.println("Account has been removed!");
    }

    public void addAccount(String name){
        Account a1 = new Account(name);
        accounts.add(a1);
    }
}