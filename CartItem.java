public class CartItem implements ShippingService {
    private Product product;
    private int quantity;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    
    // Implementing ShippingService interface methods
    @Override
    public String getName() {
        return product.getName();
    }
    
    @Override
    public double getWeight() {
        return product.getWeight() * quantity;
    }
    
    public boolean requiresShipping() {
        return product.requiresShipping();
    }
}