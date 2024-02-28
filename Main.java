// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Project 1
// 02/27/2024

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {
    public static void main(String [] args){
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
            while(run){//loop through options list on selected account

                //prints list of actions on account
                System.out.println("\n"+person1.getName()+"'s "+selectedAccount.getName());
                System.out.printf("Balance: %.2f\n", selectedAccount.getBalance());
                System.out.println("1) Withdraw Money");
                System.out.println("2) Deposit Money");
                System.out.println("3) Transfer Money");
                System.out.println("4) View Statments");
                System.out.println("5) Go back");
                System.out.println("d) *Delete Account*");
                System.out.print("\nSelect an option: ");

                String selection = reader.nextLine();
                switch (selection){
                    case "1": //withdraw
                        double selectedAmounDouble = -1;
                        System.out.print("How much would you like to withdraw? ");
                        String selectedAmount = reader.nextLine();
                        try{
                            selectedAmounDouble = Double.parseDouble(selectedAmount);
                            System.out.print("What is this transaction for? ");
                            String memo = reader.nextLine();
                            selectedAccount.withdraw(selectedAmounDouble, (""+LocalDateTime.now()).substring(0,10), memo);
                        }
                        catch(NumberFormatException e){
                            System.out.println("**Incorrect input!**");
                        }
                        break;
                    case "2": //deposit
                        selectedAmounDouble = -1;
                        System.out.print("How much would you like to deposit? ");
                        selectedAmount = reader.nextLine();
                        try{
                            selectedAmounDouble = Double.parseDouble(selectedAmount);
                            System.out.print("What is this transaction for? ");
                            String memo = reader.nextLine();
                            selectedAccount.deposit(selectedAmounDouble, (""+LocalDateTime.now()).substring(0,10), memo);
                        }
                        catch(NumberFormatException e){
                            System.out.println("**Incorrect input!**");
                        }
                        break;
                    case "3": //transfer
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
                        Account recieveAccount = null;
                
                        System.out.print("Which account would you like to send to? ");
                        selection = reader.nextLine().toLowerCase();
                
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
                                recieveAccount = accounts.get(selectionInt-1);
                            }
                            else{
                                System.out.println("**Account doesn't exist**");
                            }
                        }
                        if (recieveAccount.equals(selectedAccount)){
                            System.out.println("**Can't send to the same account**");
                            return;
                        }
                
                        //gets amount to send from user
                        double amount;
                        System.out.print("How much to do you want to transfer? ");
                        try{
                            amount = Double.parseDouble(reader.nextLine());
                        }
                        catch(NumberFormatException e){
                            System.out.println("**Invalid input**");
                            return;
                        }
                
                        //all infomation gathered, attempts transaction
                        selectedAccount.tranferTo(recieveAccount, amount, (""+LocalDateTime.now()).substring(0,10));
                        break;
                    case "4"://view statments
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
                    case "5": //go back to select account menu
                        run = false;
                        break;
                    case "d": //deletes the account currently being used
                        person1.deleteAccount(selectedAccount);
                        run = false;
                        break;
                    default: //picks up any incorrect inputs
                        System.out.println("**Incorrect Selection, please try again**");
                }
            }
        }
    }
}