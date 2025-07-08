# E-Commerce System - Fawry Task

A Java-based e-commerce system that simulates a shopping cart with checkout functionality, product management, and shipping services.

## Project Structure

```
E-Commerce-fawry/
├── Product.java           # Product entity with properties and methods
├── Customer.java          # Customer entity with balance management
├── CartItem.java          # Shopping cart item representation
├── ShoppingCart.java      # Shopping cart management
├── CheckoutService.java   # Checkout processing logic
├── ShippingService.java   # Shipping calculations and logic
└── Main.java             # Main application entry point
```

## Features

### Product Management
- **Product Properties**: Name, price, quantity, expiration status, shipping requirements, weight
- **Product Types**: 
  - Expirable products (e.g., food items)
  - Non-expirable products (e.g., electronics, scratch cards)
  - Shippable products with weight calculation
  - Digital/non-shippable products

### Shopping Cart
- Add products with specified quantities
- Calculate total amount including shipping costs
- Manage cart items with quantity validation
- Filter shippable items for shipping calculations

### Checkout Process
- **Validation Checks**:
  - Cart not empty
  - Customer has sufficient balance
  - Products are in stock and not expired
- **Transaction Processing**:
  - Deduct product quantities from inventory
  - Deduct total amount from customer balance
  - Generate detailed receipt
  - Handle shipping notifications

### Shipping Service
- Calculate shipping costs based on product weight
- Generate shipping notifications for physical products
- Weight-based shipping fee calculation

## Sample Output

![image](https://github.com/user-attachments/assets/71361156-419a-449e-a0fe-e42deffcb154)


The system demonstrates:
- Product creation with different types (Cheese, TV, Biscuits, ScratchCard)
- Customer with initial balance
- Shopping cart operations
- Checkout process with receipt generation
- Shipping notification for physical products

## How to Run

1. **Compile the Java files**:
   ```bash
   javac *.java
   ```

2. **Run the main application**:
   ```bash
   java Main
   ```

## Example Usage

```java
// Create products
Product cheese = new Product("Cheese", 200, 5, true, true, 0.4); // Expirable, shippable, 400g
Product tv = new Product("TV", 1000, 2, false, false); // Not expirable, not shippable
Product biscuits = new Product("Biscuits", 150, 10, true, false, 0.7); // Expirable, not shippable
Product scratchCard = new Product("ScratchCard", 50, 20, false, false); // Not expirable, not shippable

// Create customer
Customer customer = new Customer("John Doe", 1000);

// Create shopping cart and add items
ShoppingCart cart = new ShoppingCart();
cart.add(cheese, 2);
cart.add(tv, 3);
cart.add(scratchCard, 1);

// Process checkout
CheckoutService.checkout(customer, cart);
```

## Key Classes

### Product
- Manages product properties and inventory
- Supports both simple and weighted products
- Handles availability and quantity management

### Customer
- Manages customer information and balance
- Provides balance validation and deduction methods

### ShoppingCart
- Manages cart items and quantities
- Calculates totals including shipping costs
- Filters items by shipping requirements

### CheckoutService
- Processes the complete checkout flow
- Validates all business rules
- Generates receipts and handles shipping

### ShippingService
- Calculates shipping costs based on weight
- Manages shipping-related business logic

## Business Rules

1. **Product Availability**: Products must be in stock and not expired
2. **Customer Balance**: Customer must have sufficient balance for purchase
3. **Shipping**: Only physical products require shipping
4. **Weight Calculation**: Shipping costs are calculated based on total weight
5. **Inventory Management**: Product quantities are reduced after successful checkout

## Error Handling

The system includes comprehensive error handling for:
- Empty shopping carts
- Insufficient customer balance
- Out-of-stock products
- Expired products
- Invalid quantities
