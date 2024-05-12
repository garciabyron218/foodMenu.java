import java.util.Scanner;
import java.util.HashMap;


public class foodMenu {
    static HashMap<String, Double> menu = new HashMap<>();
    //Similar to dictionary in python, we store the menu


    //Main program runs the options, each options calls a different function
    public static void main(String [] args) {
        menu.put("sandwich", 2.00);
        menu.put("hotdog", 1.50);
        menu.put("burger", 5.00);

        Scanner input = new Scanner(System.in);

        //will only close out when the user selects exit, terminating the program
        while (true) {
            System.out.println("WHat do you want to do");
            System.out.println("1 - Calculate total");
            System.out.println("2 - Add an item to the menu");
            System.out.println("3 - Delete an item from the menu");
            System.out.println("4 - Change the price of an item");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: (1-5):  ");

            int choice = input.nextInt();
            input.nextLine();

            //each of these options will call their own functions
            switch (choice){
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
                    System.out.println("Invalid choice. Please enter your choice (1-4)");

            }
        }
    }

    // option 1 will call this function
    static void calTotal() {
    double total = 0;
    Scanner input = new Scanner(System.in);

    System.out.println("Menu");
    System.out.println(menu);

    while (true) {
        System.out.print("What items do you want to add to the bill? (or 'done' to finish): ");
        String items = input.nextLine().toLowerCase();

        if (items.equals("done")) {
        break;
        }
        if(menu.containsKey(items)){
            double price =menu.get(items);
            total += price;
        }   else {
            System.out.println("Sorry, that items is not on the menu. Try another item");
        }
    }

    System.out.printf("Your total is : $%.2f\n", total);

    }

    // option 2 will call this function
    static void addItem(Scanner input) {
        System.out.print("Enter the name of the item you want to add: ");
        String itemName = input.nextLine().toLowerCase();

        System.out.print("Enter the price of the item you want to add: ");
        double price = input.nextDouble();
        input.nextLine();

        menu.put(itemName, price);
        System.out.println("Item has been added to the menu");
    }

    // option 3 will call this function
    static void delItem(Scanner input) {
        System.out.print("Enter the name of the item you want to delete: ");
        String itemName = input.nextLine().toLowerCase();

        if(menu.containsKey(itemName)){
            menu.remove(itemName);
            System.out.println("The item as been removed from the list");
        }
        else {
            System.out.println("Sorry, that item is not on the menu. Try another item");
        }
    }

    // option 4 will call this function
    static void changePrice(Scanner input) {
        System.out.print("Enter the price of the item you want to change: ");
        String itemName = input.nextLine().toLowerCase();

        if (menu.containsKey(itemName)) {
            System.out.print("Enter the new price of the item: ");
            double newPrice = input.nextDouble();
            input.nextLine();

            menu.put(itemName, newPrice);
            System.out.print("The new price has been updated");

        } else{
            System.out.println("Sorry, that item is not on the menu. Try another item");
            }
        }
    }
