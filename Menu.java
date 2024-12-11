import java.util.Scanner;

public class Menu {
    static MenuItem[] menu = {new MenuItem("sandwich", 2.00),
                              new MenuItem("hotdog", 1.50),
                              new MenuItem("burger", 5.00)};

    // 2D array to store menu items and their prices, changed from the hashmap from last week's submission.
    //Also updated file so that the array is built using the MenuItem class using the constructor

    // Main program runs the options, each option calls a different function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // will only close out when the user selects exit/option 5, terminating the program
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1 - Calculate total");
            System.out.println("2 - Add an item to the menu");
            System.out.println("3 - Delete an item from the menu");
            System.out.println("4 - Change the price of an item");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = input.nextInt();
            input.nextLine();

            // each of these options will call their own functions, each function should call the menu to have it as reference when wanting to make a change
            switch (choice) {
                case 1:
                    calTotal();
                    break;
                case 2:
                    addItem(input);
                    break;
                case 3:
                    delItem(input);
                    break;
                case 4:
                    changePrice(input);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter your choice (1-5)");
            }
        }
    }

    // option 1 will call this function
    static void calTotal() {
        double total = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Menu");
        for (MenuItem item : menu) {
            System.out.println(item);
        }

        while (true) {
            System.out.print("What items do you want to add to the bill? (or 'done' to finish): ");
            String itemName = input.nextLine().toLowerCase();

            if (itemName.equals("done")) {
                break;
            }
            boolean itemFound = false;
            for (MenuItem menuItem : menu) {
                if (menuItem.getName().equals(itemName)) {
                    total += menuItem.getPrice();
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                System.out.println("Sorry, that item is not on the menu. Try another item");
            }
        }

        System.out.printf("Your total is: $%.2f\n", total);
    }

    // option 2 will call this function
    static void addItem(Scanner input) {
        System.out.println("Menu");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
        System.out.print("Enter the name of the item you want to add: ");
        String itemName = input.nextLine().toLowerCase();

        System.out.print("Enter the price of the item you want to add: ");
        double price = input.nextDouble();
        input.nextLine();

        // Create a new menu array with increased size
        MenuItem[] newMenu = new MenuItem[menu.length + 1];
        System.arraycopy(menu, 0, newMenu, 0, menu.length);
        newMenu[newMenu.length - 1] = new MenuItem(itemName, price);
        menu = newMenu;

        System.out.println("Item has been added to the menu");
    }

    // option 3 will call this function
    static void delItem(Scanner input) {
        System.out.println("Menu");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
        System.out.print("Enter the name of the item you want to delete: ");
        String itemName = input.nextLine().toLowerCase();

        boolean itemFound = false;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].getName().equals(itemName)) {
                MenuItem[] newMenu = new MenuItem[menu.length - 1];
                System.arraycopy(menu, 0, newMenu, 0, i);
                System.arraycopy(menu, i + 1, newMenu, i, menu.length - i - 1);
                menu = newMenu;
                itemFound = true;
                System.out.println("The item has been removed from the list");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Sorry, that item is not on the menu. Try another item");
        }
    }

    // option 4 will call this function
    static void changePrice(Scanner input) {
        System.out.println("Menu");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
        System.out.print("Enter the name of the item you want to change: ");
        String itemName = input.nextLine().toLowerCase();

        boolean itemFound = false;
        for (MenuItem menuItem : menu) {
            if (menuItem.getName().equals(itemName)) {
                System.out.print("Enter the new price of the item: ");
                double newPrice = input.nextDouble();
                input.nextLine(); // Consume newline character
                menuItem.setPrice(newPrice);
                itemFound = true;
                System.out.println("The new price has been updated");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Sorry, that item is not on the menu. Try another item");
        }
    }
}
