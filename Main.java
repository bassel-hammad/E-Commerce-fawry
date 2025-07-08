public class Main {
    public static void main(String[] args) {
        // Create products
        Product cheese = new Product("Cheese", 200, 5, true, true, 0.4); // Expirable, shippable, 400g
        Product tv = new Product("TV", 1000, 2, false, false); // Not expirable, not shippable
        Product biscuits = new Product("Biscuits", 150, 10, true, false, 0.7); // Expirable, not shippable, 700g
        Product scratchCard = new Product("ScratchCard", 50, 20, false, false); // Not expirable, not shippable
        
        // Create customer
        Customer customer = new Customer("John Doe", 1000);
        
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        
        // Add items to cart 
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
    
        CheckoutService.checkout(customer, cart);
        
        System.out.println("END.");
    }
}
