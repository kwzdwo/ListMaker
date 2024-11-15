import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> itemList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "", "[AaDdPpQq]");
            switch (choice.toUpperCase())
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (confirmQuit())
                        return;
                    break;
            }
        }
    }

    private static void displayMenu()
    {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter item to add:");
        String item = in.nextLine();
        itemList.add(item);
    }

    private static void deleteItem()
    {
        Scanner in = new Scanner(System.in);

        if (itemList.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Current list:");
        printNumberedList();
        System.out.println("Enter item number to delete:");
        int index = SafeInput.getRangedInt(in,"", itemList.size() - 1, itemList.size() + 1);
        itemList.remove(index);
    }

    private static void printList()
    {
        if (itemList.isEmpty())
        {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Current list:");
        for (String item : itemList)
        {
            System.out.println(item);
        }
    }

    private static boolean confirmQuit()
    {
        Scanner in = new Scanner(System.in);


        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N)");
    }

    private static void printNumberedList()
    {
        for (int i = 0; i < itemList.size(); i++)
        {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
}