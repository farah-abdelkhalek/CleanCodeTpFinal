package Billing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxSystemTest {

    @Test
    public void calculateTax() {
        Products product = new Products("Product", 10.0, false, "Category");
        double expectedTax = 1.0;

        double calculatedTax = TaxSystem.TAX.calculateTax(product);
        Assert.assertEquals(expectedTax, calculatedTax, 0.01);
    }

    @Test
    public void testNoTaxCalculateTax() {
        Products product = new Products("Product", 10.0, false, "Category");
        double expectedTax = 0.0;

        double calculatedTax = TaxSystem.NO_TAX.calculateTax(product);
        Assert.assertEquals(expectedTax, calculatedTax, 0.01);
    }

    @Test
    public void testImportedTaxCalculateTax() {
        Products product = new Products("Product", 10.0, true, "Category");
        double expectedTax = 1.5; // 15% of the product price

        double calculatedTax = TaxSystem.IMPORTED_TAX.calculateTax(product);
        Assert.assertEquals(expectedTax, calculatedTax, 0.01);
    }

    @Test
    public void testImportedNoTaxCalculateTax() {
        Products product = new Products("Product", 18.0, true, "Category");
        double expectedTax = 0.9;

        double calculatedTax = TaxSystem.IMPORTED_NO_TAX.calculateTax(product);
        Assert.assertEquals(expectedTax, calculatedTax, 0.01);
    }
}