public class Product {

    private String name;
    private double price;
    private int quantity;
    private boolean isExpirable;
    private boolean isExpired;
    private boolean requiresShipping;
    private double weight; // Only for shippable items
    
    // Constructor
    public Product(String name, double price, int quantity, boolean isExpirable, boolean requiresShipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isExpired = false; 
        this.requiresShipping = requiresShipping;
        this.weight = 0.0; 
    }
    
    // Constructor for shippable products with weight
    public Product(String name, double price, int quantity, boolean isExpirable, boolean requiresShipping, double weight) {
        this(name, price, quantity, isExpirable, requiresShipping); // Call the other constructor
        this.weight = weight;
    }
    
    // Getter methods (Public interface to access private data)
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public boolean isExpirable() {
        return isExpirable;
    }
    
    public boolean isExpired() {
        return isExpired;
    }
    
    public boolean requiresShipping() {
        return requiresShipping;
    }
    
    public double getWeight() {
        return weight;
    }
    
    // Setter methods
    public void setExpired(boolean expired) {
        if (isExpirable) {
            this.isExpired = expired;
        }
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Method to check if product is available
    public boolean isAvailable(int requestedQuantity) {
        return !isExpired && quantity >= requestedQuantity;
    }
    
    // Method to reduce quantity when purchased
    public void reduceQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }
}