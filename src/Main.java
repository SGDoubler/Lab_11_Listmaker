import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        boolean quit = false;
        final String menu = "A - Add D - Delete P - Print Q - Quit";
        boolean done = false;
        String cmd = "";

        do {
            //display the list
            displayList();
            //display menu options
            displayMenu();


            //get menu choice
            cmd = SafeInput.getRegExString(in,menu,"[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            //execute the choice
            switch(cmd){
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    break;
                case "Q":
                    quit = confirmQuit();
                    break;
            }

        }
        while(!quit);


    }

    private static boolean confirmQuit() {
        boolean quit = SafeInput.getYNConfirm(in, "Do you want to Quit?");
        return quit;
    }

    private static void deleteItem() {
        if (list.size() == 0){
            System.out.println("The list is empty, nothing to delete.");
            return;
        }
        displayList();
        int deletedItem = SafeInput.getRangedInt(in,"What do you want to delete?",1, list.size()) - 1;
            System.out.println(deletedItem + " removed");
        }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in,"Enter the item to add: ");
        list.add(item);
        System.out.println(item + " added to list");
    }

    private static void displayMenu() {
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
        System.out.println("Please choose a menu option: ");
    }

    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%35s", i + 1, list.get(i));
            }
        }
        else{
            System.out.println("+++         The list is empty      +++");
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
    }
}

