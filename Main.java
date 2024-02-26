// CS-280
// Derek Shannon & Sydney Nilles
// Project 1
// 02/20/2024

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

// impleted everything except transfer and viewing statments
public class Main {
    public static void main(String [] args){
        derekMainTest(); // delete if you want to test something else
    }

    public static void derekMainTest(){


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
                    //creates an account then goes back
                    System.out.print("What is the name of the account? ");
                    person1.addAccount(reader.nextLine());
                }
                else if(selection.equals("s")){
                    System.out.println("\nAccount Successfully Signed off! Good bye");
                    reader.close();
                    System.exit(0);
                }
                else{// then check to see if account exists
                    int selectionInt = -1;
                    try{
                        selectionInt = Integer.parseInt(selection);
                    }
                    catch(NumberFormatException e){
                        System.out.println("**Incorrect input!**");
                    }
                    //check selection in list
                    if (selectionInt != -1){
                        if(accounts.size()>=selectionInt && 0<selectionInt){
                            selectedAccount = accounts.get(selectionInt-1);
                            run = false;
                        }
                        else{
                            System.out.println("**Account doesn't exist**");
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
                System.out.println("4) View Statments");
                System.out.println("5) go back");
                System.out.print("\nSelect a number: ");

                String selection = reader.nextLine();
                switch (selection){
                    case "1": //withdraw
                        int selectedAmountInt = -1;
                        System.out.print("How much would you like to withdraw? ");
                        String selectedAmount = reader.nextLine();
                        try{
                            selectedAmountInt = Integer.parseInt(selectedAmount);
                            System.out.print("What is this transaction for? ");
                            String memo = reader.nextLine();
                            selectedAccount.withdraw(selectedAmountInt, (""+LocalDateTime.now()).substring(0,10), memo);
                        }
                        catch(NumberFormatException e){
                            System.out.println("**Incorrect input!**");
                        }
                        break;
                    case "2": //deposit
                        selectedAmountInt = -1;
                        System.out.print("How much would you like to deposit? ");
                        selectedAmount = reader.nextLine();
                        try{
                            selectedAmountInt = Integer.parseInt(selectedAmount);
                            System.out.print("What is this transaction for? ");
                            String memo = reader.nextLine();
                            selectedAccount.deposit(selectedAmountInt, (""+LocalDateTime.now()).substring(0,10), memo);
                        }
                        catch(NumberFormatException e){
                            System.out.println("**Incorrect input!**");
                        }
                        break;
                    case "3": //transfer needs to be implemented
                        transfer(person1, selectedAccount, reader);
                        break;
                    case "4":
                        while (true) {
                            System.out.println("Which would you like to view?\n 1) Monthly Statement\n 2) All transactions");
                            int select;
                            try{
                                select = Integer.parseInt(reader.nextLine());
                            }
                            catch(NumberFormatException e){
                                System.out.println("**Incorrect input!**");
                                break;
                            }

                            if (select > 2 && select < 1){
                                System.out.println("**Incorrect input!**");
                            } else if (select == 2){
                                selectedAccount.showStatement();
                                break;
                            } else if (select == 1){
                                String month = "" + LocalDateTime.now();
                                month = month.substring(0,8);
                                MonthlyStatement thisMonth = new MonthlyStatement(month, selectedAccount.getTransactions());
                                thisMonth.arrangeStatement();
                                break;
                            }
                        }
                        break;
                    case "5": //go back complete
                        run = false;
                        break;
                    default:
                        System.out.println("**Incorrect Selection, please try again**");
                }
            }
        }
    }
    public static void transfer(Customer person1, Account sender, Scanner reader){
        if(person1.getAccounts().size()<2){
            System.out.println("**You don't have a second account to send to!**");
            return;
        }

        //prints accounts
        ArrayList<Account> accounts = person1.getAccounts();
        for (int i = 0; i< accounts.size(); i++){
            System.out.println((i+1)+") "+accounts.get(i).getName());
        }

        //get user's choice
        Account selectedAccount = null;

        System.out.print("Which account would you like to send to? ");
        String selection = reader.nextLine().toLowerCase();

        //check for correct input
        int selectionInt = -1;
        try{
            selectionInt = Integer.parseInt(selection);
        }
        catch(NumberFormatException e){
            System.out.println("**Incorrect input!**");
        }

        //check selection in list
        if (selectionInt != -1){
            if(accounts.size()>=selectionInt && 0<selectionInt){
                selectedAccount = accounts.get(selectionInt-1);
            }
            else{
                System.out.println("**Account doesn't exist**");
            }
        }
        if (selectedAccount.equals(sender)){
            System.out.println("**Can't send to the same account**");
            return;
        }


        //gets amount to send from user
        int amount;
        System.out.print("How much to do you want to transfer? ");
        try{
            amount = Integer.parseInt(reader.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("**Invalid input**");
            return;
        }

        //all infomation gathered, attempts transaction
        sender.tranferTo(selectedAccount, amount, ""+LocalDateTime.now());
    }
}