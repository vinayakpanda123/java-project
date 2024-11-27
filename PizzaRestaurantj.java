import java.util.Scanner;

public class PizzaRestaurantj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pizza types and their prices
        String[] pizzaTypes = {"Margherita", "Pepperoni", "BBQ Chicken", "Vegetarian"};
        double[] pizzaPrices = {8.99, 9.99, 10.99, 7.99};

        // Display pizza options
        System.out.println("Welcome to the Pizza Restaurant!");
        System.out.println("Available Pizzas:");
        for (int i = 0; i < pizzaTypes.length; i++) {
            System.out.println((i + 1) + ". " + pizzaTypes[i] + " - $" + pizzaPrices[i]);
        }

        // Prompt user for pizza choice
        System.out.print("Select the pizza type (1-" + pizzaTypes.length + "): ");
        int pizzaChoice = scanner.nextInt() - 1;

        // Prompt user for size
        System.out.print("Enter the size (Small, Medium, Large): ");
        String size = scanner.next();

        // Prompt user for toppings
        System.out.print("Enter toppings (comma-separated): ");
        scanner.nextLine(); // Consume the newline
        String toppings = scanner.nextLine();

        // Prompt user for quantity
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        // Calculate total price
        double totalPrice = pizzaPrices[pizzaChoice] * quantity;

        // Display order summary
        System.out.println("\nOrder Summary:");
        System.out.println("Pizza Type: " + pizzaTypes[pizzaChoice]);
        System.out.println("Size: " + size);
        System.out.println("Toppings: " + toppings);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Price: $%.2f\n", totalPrice);

        // Close the scanner
        scanner.close();
    }
}