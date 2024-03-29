package Billing;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReceiptGeneratorTest {

    @Test
    public void testCalculateTotalPriceWithTax() {
        Products product1 = new Products("PillsAgainstMigraines", 9.75, false, "Medecine");
        Products product2 = new Products("Chocolate", 11.25, true, "Food");
        List<Products> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        double totalTax = 0.60;
        double totalPriceWithTax = ReceiptGenerator.calculateTotalPriceWithTax(productList, totalTax);

        double expectedTotalPriceWithTax = product1.getPrice() + product2.getPrice() + totalTax;
        assertEquals(expectedTotalPriceWithTax, totalPriceWithTax, 0.01);
    }

    @Test
    public void testRoundTaxAmount() {
        double taxAmount = 3.27;
        double roundedTaxAmount = ReceiptGenerator.roundTaxAmount(taxAmount);
        double expectedRoundedTaxAmount = 3.30;

        assertEquals(expectedRoundedTaxAmount, roundedTaxAmount, 0.01);
    }

}