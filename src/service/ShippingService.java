package service;

import interfaces.Shippable;
import model.Product;

import java.util.HashMap;

public class ShippingService {
    public static double ship(HashMap<Shippable, Double> items) {
        if (items.isEmpty()) {
            return 0;
        }
        System.out.println("** Shipment notice **");
        double totalWeightGrams = 0;
        for (Shippable item : items.keySet()) {
            double quantity = items.get(item);
            double itemWeight = item.getWeight() * quantity;
            totalWeightGrams += itemWeight;
            System.out.printf("%.0fx %s\t%.0fg%n", quantity, ((Product)item).getName(), itemWeight);
        }
        System.out.printf("Total package weight %.1fkg%n%n", totalWeightGrams / 1000);
        return totalWeightGrams / 1000;
    }
}
