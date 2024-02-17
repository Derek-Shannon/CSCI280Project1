import java.util.Scanner;
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
        
        System.out.println("Welcome "+person1.getName()+", what would you like to do?");
        System.out.println("1) Withdraw Money");
        System.out.println("2) Deposit Money");
        System.out.println("3) Transfer Money");
        System.out.println("4) go back");
    }
}