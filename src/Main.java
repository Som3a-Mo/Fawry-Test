import model.*;
import service.InvoiceServices;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new GroceryItem("Cheese", 5.0, 10, "2025-06-25", 10, 500));
        list.add(new GroceryItem("Biscuits", 2.5, 20, "2025-06-01", 30, 300));
        list.add(new Electronics("TV", 300, 5, 10_000));
        list.add(new DigitalProduct("ScratchCard", 2, 100, "2025-06-01", 365));

        Inventory inv = new Inventory(list);
        InvoiceServices.setInventory(inv);

        Customer cust = new Customer("Alice", 1000);
        Cart cart = new Cart();
        cart.add("Cheese", 2);
        cart.add("TV", 1);
        cart.add("ScratchCard", 3);

        InvoiceServices.checkout(cust, cart);
    }
}
