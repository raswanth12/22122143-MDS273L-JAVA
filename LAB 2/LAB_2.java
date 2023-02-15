import java.util.*;

public class LAB_2 {
    static final int MAX_NAMES = 1024;
    static String[] names = new String[MAX_NAMES];
    static int numNames = 0;

    public static void main(String[] args) {
        System.out.println("welcome You");
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            // System.out.println("Menu:");
            System.out.println("1. Enter a name");
            System.out.println("2. Search for a name");
            System.out.println("3. Remove a name");
            System.out.println("4. Show all names");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    enterName(scan);
                    break;
                case 2:
                    searchName(scan);
                    break;
                case 3:
                    removeName(scan);
                    break;
                case 4:
                    showAllNames();
                    break;
                case 0:
                    System.out.println("Thank you...");
                    System.out.println("*BYE*..Have a great DAY....!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
        scan.close();
    }

    // Function to enter a name
    static void enterName(Scanner scan) {
        System.out.print("Enter a name: ");
        String name = scan.next();
        if (numNames == MAX_NAMES) {
            System.out.println("Array is full. Cannot enter more names.");
        } else if (isNameExists(name)) {
            System.out.println("Name already exists. Enter a unique name.");
        } else {
            names[numNames++] = name;
            System.out.println("Name is taken successfully..");
        }
        System.out.println("Ready for Name to enter 1 to Gooo! "); 
    }

    private static boolean isNameExists(String name) {
        return false;
    }

    // Function to search for a name
    static void searchName(Scanner scan) {
        System.out.print("Enter a name to search: ");
        String name = scan.next();
        int index = searchNameIndex(name);
        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            System.out.println("Name found at index " + index + ".");
        }
    }

    private static int searchNameIndex(String name) {
        return 0;
    }

    // Function to remove a name
    static void removeName(Scanner scan) {
        System.out.print("Enter a name to remove: ");
        String name = scan.next();
        int index = searchNameIndex(name);
        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            for (int i = index; i < numNames - 1; i++) {
                names[i] = names[i + 1];
            }
            numNames--;
            System.out.println("Name removed successfully.");
            
        }
        System.out.println("Ready for next task you can go....");

    }

    static void showAllNames() {
        System.out.println("All names:");
        for (int i = 0; i < numNames; i++) {
            System.out.println((i + 1) + ". " + names[i]);
            
        }
        System.out.println("Ready for next task you can go....");

        
    }

}

  