import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        derekMainTest(); // delete if you want to test
    }
    public static void derekMainTest(){

        //this is just a start and NOT complete at ALL

        Scanner reader = new Scanner(System.in);

        System.out.println("----Welcome To Our Bank!----");
        System.out.print("Please eneter your name: ");
        String name = reader.nextLine();
        System.out.println();

        Customer person1 = new Customer(name);
        
        boolean run = true;
        while(run){
            System.out.println("\n\nWelcome "+person1.getName()+"!");

            //print account list
            ArrayList<Account> accounts = person1.getAccounts();
            for (int i = 0; i< accounts.size(); i++){
                System.out.println(i+") "+accounts.get(i));
            }
            if (accounts.size()==0){
                System.out.println("(No accounts Found, type 'c' to create an account)");
            }
            System.out.println("c) create account");

            //get user's choice
            System.out.print("\nWhat would you like to do? ");
            String selection = reader.nextLine();

            if(selection.equals("c")){ //create new account
                //create an account then go back
                System.out.print("What is the name of the account? ");
                person1.addAccount(reader.nextLine());
            }
            else{// then check to see if account exists
                int selectionInt;
                try{
                    selectionInt = Integer.parseInt(selection);
                }
                catch(NumberFormatException e){
                    System.out.println("incorrect input!");
                    run = true;
                }
                //check selection in list
            }
        }

        //temp
        Account selectedAccount = new Account("Checking");



        //actions on account
        System.out.println(person1.getName()+"'s "+selectedAccount.getName()+" Account Actions");
        System.out.println("1) Withdraw Money");
        System.out.println("2) Deposit Money");
        System.out.println("3) Transfer Money");
        System.out.println("4) go back");
        System.out.print("\nSelect a number: ");

        String selection = reader.nextLine();
        switch (selection){
            case "1":
                //
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Incorrect Selection, please try again");
        }
    }
}