# Fawry‑Test

A clean, object‑oriented Java application that simulates a simple checkout system with:
- Perishable grocery items
- Physical electronics
- Digital products  
Support for **expiration**, **shipping**, **stock**, **balance checking**, and console‑based invoicing.


## 🛠️ Features

- **Products** categorized as:
  - `GroceryItem` (expirable + shippable)
  - `Electronics` (shippable)
  - `DigitalProduct` (expirable)
- **Cart** supports adding items by name and quantity
- **Inventory** handles product lookup and stock tracking
- **Checkout** enforces business rules:
  - Rejects empty cart
  - Validates product existence, expiry, stock
  - Calculates shipping cost and weight
  - Prints shipment notice and invoice receipt
  - Updates customer balance and product stock
- **SOLID**-inspired design and clean code


## 📁 Project Structure

<details>
<summary>Click to expand!</summary>
  
```bash
## Project Structure
src/
├── com.yourname.store
│ ├── Main.java # Console demo app
│ ├── model/
│ │ ├── Cart.java
│ │ ├── CartProduct.java
│ │ ├── Customer.java
│ │ ├── Inventory.java
│ │ ├── Product.java
│ │ ├── ExpirableProduct.java
│ │ ├── GroceryItem.java
│ │ ├── Electronics.java
│ │ └── DigitalProduct.java
│ ├── interfaces/
│ │ ├── Expirable.java
│ │ └── Shippable.java
│ └── service/
│ ├── InvoiceService.java
│ └── ShippingService.java

```
</details>

## 🚀 Getting Started

### Prerequisites
- Java 8 or newer
- IDE (e.g., IntelliJ IDEA, Eclipse) or command‑line tools

### Build & Run

1. **Clone the repo:**
   ```bash
   git clone https://github.com/Som3a-Mo/Fawry-Test.git
   cd Fawry-Test
   ```
2. **Compile & run with your IDE, or via command line**
 
3. **Sample Demo (from Main.java):**
   ```csh
   cart.add("Cheese", 2);
   cart.add("TV", 1);
   cart.add("ScratchCard", 3);
   InvoiceServices.checkout(cust, cart);
   ```
   
   **Produces:**
    ```bash
    ** Shipment notice **
    1x TV	10000g
    2x Cheese	1000g
    Total package weight 11.0kg
    
    ** Checkout receipt **
    3x ScratchCard	6
    1x TV	300
    2x Cheese	10
    ----------------------
    Subtotal    316
    Shipping    110
    Amount      426
    ```

### Screenshots 
![image](https://github.com/user-attachments/assets/80266990-964f-45a9-b9de-982ce856cbc1)
![image](https://github.com/user-attachments/assets/5e42c659-cf9d-4137-b392-92e6e0f2e31d)

## 🧩 How it Works
- `InvoiceService.checkout(...)` loops through cart, performing:
    - Product existence check    
    - Expiry & stock validation  
    - Shipping & receipt item collection
    - Price & balance calculations
    - Updates stock & balance
    - Prints shipment and invoice to console
- `ShippingService` handles weight computation and printing.



