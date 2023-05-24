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
        products.add(new Products("Perfume", 18.99, false, "Cosmetic"));
        products.add(new Products("Chocolate", 11.25, true, "Food"));
        products.add(new Products("PillsAgainstMigraines", 9.75, false, "Medecine"));

        double expectedTaxAmount = 2.50;

        TaxCalculation taxCalculation = new TaxCalculation();
        double calculatedTaxAmount = taxCalculation.calculateTaxAmount(products);

        Assert.assertEquals(expectedTaxAmount, calculatedTaxAmount, 0.01);
    }

    @Test
    public void testGetTaxAmount() {
        Products product = new Products("LordOfTheFlies", 12.87, true, "Book");
        double expectedTaxAmount = 0.70;

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