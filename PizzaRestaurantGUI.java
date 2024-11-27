import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaRestaurantGUI {
    private static String[] pizzaTypes = {"Margherita", "Pepperoni", "BBQ Chicken", "Vegetarian"};
    // Prices for Small, Medium, and Large for each pizza type
    private static double[][] pizzaPrices = {
        {8.99, 10.99, 12.99}, // Margherita prices: Small, Medium, Large
        {9.99, 11.99, 13.99}, // Pepperoni prices: Small, Medium, Large
        {10.99, 12.99, 14.99}, // BBQ Chicken prices: Small, Medium, Large
        {7.99, 9.99, 11.99}    // Vegetarian prices: Small, Medium, Large
    };

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Pizza Restaurant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLayout(null);

        // Create components
        JLabel titleLabel = new JLabel("Welcome to the Pizza Restaurant!");
        titleLabel.setBounds(50, 10, 300, 20);
        
        JLabel pizzaLabel = new JLabel("Select Pizza Type:");
        pizzaLabel.setBounds(20, 40, 150, 20);
        
        JComboBox<String> pizzaComboBox = new JComboBox<>(pizzaTypes);
        pizzaComboBox.setBounds(180, 40, 150, 20);
        
        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(20, 80, 150, 20);
        
        String[] sizes = {"Small", "Medium", "Large"};
        JComboBox<String> sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setBounds(180, 80, 150, 20);
        
        JLabel toppingsLabel = new JLabel("Toppings (comma-separated):");
        toppingsLabel.setBounds(20, 120, 200, 20);
        
        JTextField toppingsField = new JTextField();
        toppingsField.setBounds(20, 150, 310, 20);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 190, 150, 20);
        
        JTextField quantityField = new JTextField();
        quantityField.setBounds(180, 190, 150, 20);
        
        JButton orderButton = new JButton("Place Order");
        orderButton.setBounds(20, 230, 150, 30);
        
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(20, 270, 350, 80);
        outputArea.setEditable(false);
        
        JLabel billLabel = new JLabel("Total Amount of Bill:");
        billLabel.setBounds(20, 360, 150, 20);
        
        JTextField totalBillField = new JTextField();
        totalBillField.setBounds(180, 360, 150, 20);
        totalBillField.setEditable(false); // Make it read-only
        
        // Add components to the frame
        frame.add(titleLabel);
        frame.add(pizzaLabel);
        frame.add(pizzaComboBox);
        frame.add(sizeLabel);
        frame.add(sizeComboBox);
        frame.add(toppingsLabel);
        frame.add(toppingsField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(orderButton);
        frame.add(outputArea);
        frame.add(billLabel);
        frame.add(totalBillField);
        
        // Add action listener to the order button
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pizzaChoice = pizzaComboBox.getSelectedIndex();
                int sizeChoice = sizeComboBox.getSelectedIndex(); // 0 for Small, 1 for Medium, 2 for Large
                String size = (String) sizeComboBox.getSelectedItem();
                String toppings = toppingsField.getText();
                int quantity;

                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    double totalPrice = pizzaPrices[pizzaChoice][sizeChoice] * quantity;

                    // Display order summary
                    String orderSummary = "Order Summary:\n" +
                            "Pizza Type: " + pizzaTypes[pizzaChoice] + "\n" +
                            "Size: " + size + "\n" +
                            "Toppings: " + toppings + "\n" +
                            "Quantity: " + quantity + "\n";
                    outputArea.setText(orderSummary);
                    
                    // Display total amount in the separate field
                    totalBillField.setText(String.format("$%.2f", totalPrice));
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter a valid quantity.");
                    totalBillField.setText(""); // Clear the total bill field on error
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}