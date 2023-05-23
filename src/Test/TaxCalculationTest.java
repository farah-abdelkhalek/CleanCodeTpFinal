package Test;

import Billing.Products;
import Billing.TaxCalculation;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculationTest {
    public static void main(String[] args) {
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products("Imported bottle of perfume", 27.99, true, "Cosmetic"));
        productsList.add(new Products("Bottle of perfume", 18.99, false, "Cosmetic"));
        productsList.add(new Products("Box of migraine medication", 9.75, false, "Medicine"));
        productsList.add(new Products("Box of imported chocolates", 11.25, true, "Food"));

        TaxCalculation taxCalculation = new TaxCalculation();

        double totalTaxAmount = taxCalculation.calculateTaxAmount(productsList);

        System.out.println("Tax amount :"+ totalTaxAmount, "€");
        System.out.println("Total:" + calculateTotalAmount(productsList, totalTaxAmount), "€");
    }

    private static double calculateTotalAmount(List<Products> productsList, double totalTaxAmount) {
        double totalAmount = 0;

        for (Products product : productsList) {
            totalAmount += product.getPrice();
        }

        return totalAmount + totalTaxAmount;
    }
}
