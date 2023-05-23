package Billing;

import Billing.Products;
import Billing.TaxSystem;

public class TaxSystemTest {
    public static void main(String[] args) {
        Products product = new Products("perfume", 27.99, true, "Cosmetic");

        double taxAmount = TaxSystem.TAX.calculateTax(product);
        System.out.println("Tax Amount (TAX): €" + taxAmount);

        taxAmount = TaxSystem.NO_TAX.calculateTax(product);
        System.out.println("Tax Amount (NO_TAX): €" + taxAmount);

        taxAmount = TaxSystem.IMPORTED_TAX.calculateTax(product);
        System.out.println("Tax Amount (IMPORTED_TAX): €" + taxAmount);

        taxAmount = TaxSystem.IMPORTED_NO_TAX.calculateTax(product);
        System.out.println("Tax Amount (IMPORTED_NO_TAX): €" + taxAmount);
    }
}
