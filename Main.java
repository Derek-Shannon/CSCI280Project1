public class Main {
    public static void main(String [] args){
        Account first = new Account("Checking");
        Account second = new Account("Checking");
        System.out.println(first.getID());
        System.out.println(second.getID());
        first.setID(8);
        System.out.println(first.getID());
        System.out.println(second.getID());
        second.setID(8);
        System.out.println(first.getID());
        System.out.println(second.getID());
        first.setID(8);
        System.out.println(first.getID());
        System.out.println(second.getID());
    }
}
