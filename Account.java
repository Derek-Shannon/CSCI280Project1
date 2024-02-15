import java.util.ArrayList;

class Account{
    private static ArrayList<Integer> idList = new ArrayList<Integer>();
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

    public void setName(String name){
        this.name = name;
    }

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
     * @param amount to be added to the account
     */
    public void deposit(int amount){
        balance += amount;
        //add transaction log
    }

    /*
     * removes money from the account
     * @param amount to be added to the account
     */
    public void withdraw(int amount){
        if (balance < 0){
            System.out.println("Not enough funds to withdraw");
            return;
        }
        balance -= amount;
        //add to transaction log
        checkFee();
    }

    public void checkFee(){
        if (balance < 0){
            int fee = 18;
            //add transaction for fee
            balance -= fee;
        }
    }

    /*
     * transfers money from the account to another account provide
     * @param recipient - the account that is recieveing the money
     * @param amount - the quantity of money being transfered to the other account
     */
    public void tranferTo(Account recipient, int amount){
        if (amount < 0){
            System.out.println("Amount to send can't be negative");
            return;
        }
        if (amount > balance){
            System.out.println("Not enough funds to transfer");
            return;
        }
        balance -= amount;
        checkFee();
        recipient.balance += amount;
        //add to transaction log
    }

    /*
     * Prints organized text of all transactions from that account.
     */
    public void showStatment(){}
}