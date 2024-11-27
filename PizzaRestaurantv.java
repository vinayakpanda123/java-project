import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

class Pizza {
    private String type; // Type of the pizza
    private String size; // Size of the pizza
    private Vector<String> toppings; // Vector to store toppings
    private double basePrice; // Base price of the pizza

    // Constructor that initializes the type, size, and base price
    public Pizza(String type, String size) {
        this.type = type;
        this.size = size;
        this.toppings = new Vector<>(); // Initialize the toppings vector
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
        toppings.add(topping); // Add topping to the vector
    }

    // Method to calculate the total price of the pizza
    public double calculateTotalPrice() {
        return basePrice + (toppings.size() * 1.50); // Each topping costs $1.50
    }

    // Override toString method to display pizza details
    @Override
    public String toString() {
        return "Pizza Type: " + type + ", Size: " + size + ", Toppings: " + toppings + ", Total Price: $" + String.format("%.2f", calculateTotalPrice());
    }
}

public class PizzaRestaurantv {
    // Map to store available toppings
    private static final HashMap<String, String[]> availableToppings = new HashMap<>();

    // Static block to initialize available toppings
    static {
        availableToppings.put("pepperoni", new String[]{"pepperoni"});
        availableToppings.put("mushrooms", new String[]{"mushrooms"});
        availableToppings.put("onions", new String[]{"onions"});
        availableToppings.put("sausage", new String[]{"sausage"});
        availableToppings.put("bacon", new String[]{"bacon"});
        availableToppings.put("extra cheese", new String[]{"extra cheese"});
        availableToppings.put("black olives", new String[]{"black olives"});
        availableToppings.put("green peppers", new String[]{"green peppers"});
        availableToppings.put("pineapple", new String[]{"pineapple"});
        availableToppings.put("spinach", new String[]{"spinach"});
    }

    // Map to store available pizza types
    private static final String[] availablePizzaTypes = {"Margherita", "Pepperoni", "Veggie", "BBQ Chicken"};

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
        System .out.print("Choose pizza size (small, medium, large): ");
        String size = scanner.nextLine();

        // Create a new pizza object
        Pizza pizza = new Pizza(type, size);

        // Display available toppings
        System.out.println("Available toppings: ");
        for (String topping : availableToppings.keySet()) {
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
            if (availableToppings.containsKey(topping.toLowerCase())) {
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