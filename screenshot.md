# Screenshot of E-Commerce System Output

This file represents the terminal output screenshot showing the E-Commerce system in action.

## Terminal Output:
```
PS C:\Users\DELL\Desktop\Fawry task\E-Commerce-fawry> javac *.java
PS C:\Users\DELL\Desktop\Fawry task\E-Commerce-fawry> java Main
Error: Product TV is not available or expired
** Checkout receipt **
2x Cheese        400
1x ScratchCard   50
---------------
Subtotal         450
Shipping         24
Amount           474

** Shipment notice **
2x Cheese        800g
Total package weight 0.80kg
```

## Key Points Demonstrated:
1. **Java Compilation**: The project compiles successfully with `javac *.java`
2. **Execution**: Running with `java Main` processes the checkout
3. **Error Handling**: System detects that TV is not available or expired
4. **Receipt Generation**: Shows itemized receipt with subtotal, shipping, and total
5. **Shipping Notice**: Displays shippable items with weight calculations
6. **Business Logic**: Only processes available items and calculates appropriate fees
