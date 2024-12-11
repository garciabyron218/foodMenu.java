public class MenuItem {
    private String name;
    private double price;

    // Constructor for food item
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for food item
    public String getName() {
        return name;
    }

    // Setter for food item
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // toString method, formatted to show as currency, not sure is this is enough for description or the assignment wants an actual description of the food item
    @Override
    public String toString() {
        return String.format("%s: $%.2f", name, price);
    }
}
