package Billing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaxCalculationTest {
    @Test
    public void testCalculateTaxAmount() {
        List<Products> products = new ArrayList<>();
        products.add(new Products("Product 1", 10.0, false, "Category 1"));
        products.add(new Products("Product 2", 20.0, true, "Category 2"));
        products.add(new Products("Product 3", 30.0, false, "Category 3"));

        double expectedTaxAmount = 7.0;

        TaxCalculation taxCalculation = new TaxCalculation();
        double calculatedTaxAmount = taxCalculation.calculateTaxAmount(products);

        Assert.assertEquals(expectedTaxAmount, calculatedTaxAmount, 0.01);
    }

    @Test
    public void testGetTaxAmount() {
        Products product = new Products("Product", 10.0, true, "Category");
        double expectedTaxAmount = 1.5;

        TaxCalculation taxCalculation = new TaxCalculation();
        double calculatedTaxAmount = taxCalculation.getTaxAmount(product);

        Assert.assertEquals(expectedTaxAmount, calculatedTaxAmount, 0.01);
    }

    @Test
    public void testIsTaxExempt() {
        Products foodProduct = new Products("Food Product", 10.0, false, "Food");
        Products medicineProduct = new Products("Medicine Product", 20.0, false, "Medicine");
        Products bookProduct = new Products("Book Product", 30.0, false, "Book");

        TaxCalculation taxCalculation = new TaxCalculation();

        Assert.assertTrue(taxCalculation.isTaxExempt(foodProduct));
        Assert.assertTrue(taxCalculation.isTaxExempt(medicineProduct));
        Assert.assertTrue(taxCalculation.isTaxExempt(bookProduct));
    }

    @Test
    public void testGetTaxSystem() {
        Products importedProduct = new Products("Imported Product", 10.0, true, "Category");
        Products nonImportedProduct = new Products("Non-Imported Product", 20.0, false, "Category");

        TaxCalculation taxCalculation = new TaxCalculation();

        Assert.assertEquals(TaxSystem.IMPORTED_TAX, taxCalculation.getTaxSystem(importedProduct));
        Assert.assertEquals(TaxSystem.TAX, taxCalculation.getTaxSystem(nonImportedProduct));
    }

}