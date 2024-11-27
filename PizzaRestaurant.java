import java.util.HashMap;
import java.util.Scanner;

class Pizza {
    private String type; // Type of the pizza
    private String size; // Size of the pizza
    private String[] toppings; // Array to store toppings
    private int toppingCount; // Count of toppings added
    private double basePrice; // Base price of the pizza

    // Constructor that initializes the type, size, and base price
    public Pizza(String type, String size) {
        this.type = type;
        this.size = size;
        this.toppings = new String[10]; // Assuming a max of 10 toppings
        this.toppingCount = 0; // Initialize topping count
        this.basePrice = calculateBasePrice(type, size); // Calculate base price based on type and size
    }

    // Method to calculate the base price based on the type and size
    private double calculateBasePrice(String type, String size) {
        double typeBasePrice;
        switch (type.toLowerCase()) {
            case "margherita":
                typeBasePrice = 8.00;
                break;
            case "pepperoni":
                typeBasePrice = 9.00;
                break;
            case "veggie":
                typeBasePrice = 8.50;
                break;
            case "bbq chicken":
                typeBasePrice = 10.00;
                break;
            default:
                typeBasePrice = 0.00; // Return 0 if type is invalid
        }

        // Adjust base price based on size
        double sizeMultiplier;
        switch (size.toLowerCase()) {
            case "small":
                sizeMultiplier = 1.0; // No extra charge for small
                break;
            case "medium":
                sizeMultiplier = 1.25; // 25% extra for medium
                break;
            case "large":
                sizeMultiplier = 1.5; // 50% extra for large
                break;
            default:
                sizeMultiplier = 0.0; // Return 0 if size is invalid
        }

        return typeBasePrice * sizeMultiplier; // Calculate total base price
    }

    // Method to add a topping to the pizza
    public void addTopping(String topping) {
        if (toppingCount < toppings.length) {
            toppings[toppingCount++] = topping; // Add topping to the array
        } else {
            System.out.println("Maximum toppings reached.");
        }
    }

    // Method to calculate the total price of the pizza
    public double calculateTotalPrice() {
        return basePrice + (toppingCount * 1.50); // Each topping costs $1.50
    }

    // Override toString method to display pizza details
    @Override
    public String toString() {
        StringBuilder toppingList = new StringBuilder();
        for (int i = 0; i < toppingCount; i++) {
            toppingList.append(toppings[i]);
            if (i < toppingCount - 1) {
                toppingList.append(", ");
            }
        }
        return "Pizza Type: " + type + ", Size: " + size + ", Toppings: " + toppingList.toString() + ", Total Price: $" + String.format("%.2f", calculateTotalPrice());
    }
}

public class PizzaRestaurant {
    // Array to store available toppings
    private static final String[] availableToppings = {
        "pepperoni", "mushrooms", "onions", "sausage", 
        "bacon", "extra cheese", "black olives", 
        "green peppers", "pineapple", "spinach"
    };

    // Array to store available pizza types
    private static final String[] availablePizzaTypes = {
        "Margherita", "Pepperoni", "Veggie", "BBQ Chicken"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        System.out.println("Welcome to the Pizza Restaurant!");

        // Prompt user to choose pizza type
        System.out.println("Available pizza types: ");
        for (String pizzaType : availablePizzaTypes) {
            System.out.println("- " + pizzaType);
        }
        System.out.print("Choose pizza type: ");
        String type = scanner.nextLine();

        // Prompt user to choose pizza size
        System.out.print("Choose pizza size (small, medium, large): ");
        String size = scanner.nextLine();

        // Create a new pizza object
        Pizza pizza = new Pizza(type, size);

        // Display available toppings
        System.out.println("Available toppings: ");
 for (String topping : availableToppings) {
            System.out.println("- " + topping);
        }

        // Prompt user to enter toppings
        System.out.println("Enter your toppings (type 'done' when finished): ");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) {
                break; // Exit loop if user is done
            }
            // Check if the topping is available
            boolean isAvailable = false;
            for (String availableTopping : availableToppings) {
                if (availableTopping.equalsIgnoreCase(topping)) {
                    isAvailable = true;
                    break;
                }
            }
            if (isAvailable) {
                pizza.addTopping(topping); // Add topping to the pizza
            } else {
                System.out.println("Topping not available. Please choose another.");
            }
        }

        // Ask for the quantity of the pizza
        System.out.print("How many pizzas of this type would you like to order? ");
        int quantity = scanner.nextInt();

        // Calculate total price for the order
        double totalOrderPrice = pizza.calculateTotalPrice() * quantity;

        // Display the final order summary
        System.out.println("Your Order:");
        System.out.println(pizza);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price for " + quantity + " pizzas: $" + String.format("%.2f", totalOrderPrice));

        scanner.close(); // Close the scanner
    }
}