import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String [] args){
        derekMainTest(); // delete if you want to test
    }
    public static void derekMainTest(){

        //this is just a start and NOT complete at ALL

        Scanner reader = new Scanner(System.in);

        System.out.println("----Welcome To Our Bank!----");
        System.out.print("Please enter your name: ");
        String name = reader.nextLine();
        System.out.println();

        Customer person1 = new Customer(name);
        
        while(true){ //loops the entire menu system

            //finds the account the user wants to interact with
            Account selectedAccount = null;
            boolean run = true;
            while(run){
                System.out.println("\n\nWelcome "+person1.getName()+"!");

                //print account list
                ArrayList<Account> accounts = person1.getAccounts();
                for (int i = 0; i< accounts.size(); i++){
                    System.out.println((i+1)+") "+accounts.get(i).getName());
                }
                if (accounts.size()==0){
                    System.out.println("(No accounts Found, type 'c' to create an account)");
                }
                System.out.println("c) create account");
                System.out.println("s) Sign Off");

                //get user's choice
                System.out.print("\nWhat would you like to do? ");
                String selection = reader.nextLine().toLowerCase();

                //check to create new account
                if(selection.equals("c")){
                    //create an account then go back
                    System.out.print("What is the name of the account? ");
                    person1.addAccount(reader.nextLine());
                }
                else if(selection.equals("s")){
                    System.out.println("\nAccount Successfully Signed off! Good bye");
                    System.exit(0);
                }
                else{// then check to see if account exists
                    int selectionInt = -1;
                    try{
                        selectionInt = Integer.parseInt(selection);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Incorrect input!");
                    }
                    //check selection in list
                    if (selectionInt != -1){
                        if(accounts.size()>=selectionInt && 0<selectionInt){
                            selectedAccount = accounts.get(selectionInt-1);
                            run = false;
                        }
                        else{
                            System.out.println("Account doesn't exist");
                        }
                    }
                }
            }

            run = true;
            while(run){

                //actions on account
                System.out.println("\n"+person1.getName()+"'s "+selectedAccount.getName());
                System.out.println("Balance: "+selectedAccount.getBalance());
                System.out.println("1) Withdraw Money");
                System.out.println("2) Deposit Money");
                System.out.println("3) Transfer Money");
                System.out.println("4) go back");
                System.out.print("\nSelect a number: ");

                String selection = reader.nextLine();
                switch (selection){
                    case "1":
                        int selectedAmountInt = -1;
                        System.out.print("How much would you like to withdraw? ");
                        String selectedAmount = reader.nextLine();
                        try{
                            selectedAmountInt = Integer.parseInt(selectedAmount);
                            selectedAccount.withdraw(selectedAmountInt, ""+LocalDateTime.now());
                        }
                        catch(NumberFormatException e){
                            System.out.println("incorrect input!");
                        }
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        run = false;
                        break;
                    default:
                        System.out.println("Incorrect Selection, please try again");
                }
            }
        }
    }
    public static void getDate(){
        
    }
}