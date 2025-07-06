
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    private static final double SHIPPING_RATE_PER_KG = 30.0; // 30 per kg as shown in example
    
    public ShoppingCart() {
        items = new ArrayList<>();
    }
    
    // Add product to cart
    public boolean add(Product product, int quantity) {
        // Check if product is available
        if (!product.isAvailable(quantity)) {
            System.out.println("Error: Product " + product.getName() + " is not available or expired");
            return false;
        }
        
        // Check if item already exists in cart
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                // Update quantity if item exists
                int newQuantity = item.getQuantity() + quantity;
                if (product.isAvailable(newQuantity)) {
                    items.remove(item);
                    items.add(new CartItem(product, newQuantity));
                    return true;
                } else {
                    System.out.println("Error: Not enough stock for " + product.getName());
                    return false;
                }
            }
        }
        
        // Add new item to cart
        items.add(new CartItem(product, quantity));
        return true;
    }
    
    // Calculate subtotal (sum of all items' prices)
    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }
    
    // Calculate shipping cost
    public double getShippingCost() {
        double totalWeight = 0.0;
        for (CartItem item : items) {
            if (item.requiresShipping()) {
                totalWeight += item.getWeight();
            }
        }
        return totalWeight * SHIPPING_RATE_PER_KG;
    }
    
    // Calculate total amount
    public double getTotalAmount() {
        return getSubtotal() + getShippingCost();
    }
    
    // Get items that need shipping
    public List<CartItem> getShippableItems() {
        List<CartItem> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            if (item.requiresShipping()) {
                shippableItems.add(item);
            }
        }
        return shippableItems;
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (CartItem item : items) {
            if (item.requiresShipping()) {
                totalWeight += item.getWeight();
            }
        }
        return totalWeight;
    }
}