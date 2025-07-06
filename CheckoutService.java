import java.util.List;

public class CheckoutService {
    
    public static boolean checkout(Customer customer, ShoppingCart cart) {
        // Check if cart is empty
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return false;
        }
        
        double totalAmount = cart.getTotalAmount();
        
        // Check if customer has enough balance
        if (!customer.hasEnoughBalance(totalAmount)) {
            System.out.println("Error: Customer's balance is insufficient");
            return false;
        }
        
        // Check if any product is out of stock or expired
        for (CartItem item : cart.getItems()) {
            if (!item.getProduct().isAvailable(item.getQuantity())) {
                System.out.println("Error: One product is out of stock or expired");
                return false;
            }
        }
        
        // Process the checkout
        // Deduct quantities from products
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        
        // Deduct amount from customer balance
        customer.deductBalance(totalAmount);
        
        // Print receipt
        printReceipt(customer, cart);
        
        // Handle shipping if needed
        List<CartItem> shippableItems = cart.getShippableItems();
        if (!shippableItems.isEmpty()) {
            System.out.println("** Shipment notice **");
            for (CartItem item : shippableItems) {
                System.out.println(item.getQuantity() + "x " + item.getName() + "\t\t" + 
                                 (int)(item.getWeight() * 1000) + "g"); // Convert to grams
            }
            System.out.println("Total package weight " + String.format("%.2f", cart.getTotalWeight()) + "kg");
            System.out.println();
        }
        
        return true;
    }
    
    private static void printReceipt(Customer customer, ShoppingCart cart) {
        System.out.println("** Checkout receipt **");
        
        // Print items
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getName() + "\t\t" + 
                             (int)item.getTotalPrice());
        }
        
        System.out.println("----------------------");
        System.out.println("Subtotal\t\t" + (int)cart.getSubtotal());
        System.out.println("Shipping\t\t" + (int)cart.getShippingCost());
        System.out.println("Amount\t\t\t" + (int)cart.getTotalAmount());
        System.out.println();
    }
}