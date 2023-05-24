package Billing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ReceiptTest {

    private List<Products> productsList;
    private double totalTax;
    private double totalPriceWithTax;
    private Receipt receipt;

    @Before
    public void setup() {
        productsList = new ArrayList<>();
        productsList.add(new Products("Perfume", 18.99, false, "Cosmetic"));
        productsList.add(new Products("Chocolate", 11.25, true, "Food"));
        productsList.add(new Products("PillsAgainstMigraines", 9.75, false, "Medecine"));

        totalTax = 2.50;
        totalPriceWithTax = 42.50;

        receipt = new Receipt(productsList, totalTax, totalPriceWithTax);
    }

    @Test
    public void getListOfProducts() {
        List<Products> retrievedProductsList = receipt.getListOfProducts();

        Assert.assertEquals(productsList.size(), retrievedProductsList.size());
        Assert.assertTrue(retrievedProductsList.containsAll(productsList));
    }

    @Test
    public void getProductCountMap() {
        Map<Products, Integer> productCountMap = receipt.getProductCountMap();
        for (Products product : productsList) {
            int count = productCountMap.getOrDefault(product, 0);
            Assert.assertEquals(1, count);
        }
    }

    @Test
    public void getTotalTax() {
        double retrievedTotalTax = receipt.getTotalTax();
        Assert.assertEquals(totalTax, retrievedTotalTax, 0.01);
    }

    @Test
    public void getTotalPriceWithTax() {
        double retrievedTotalPriceWithTax = receipt.getTotalPriceWithTax();
        Assert.assertEquals(totalPriceWithTax, retrievedTotalPriceWithTax, 0.01);
    }

    @Test
    public void getTotalPriceWithoutTax() {
        double retrievedTotalPriceWithoutTax = receipt.getTotalPriceWithoutTax();
        Assert.assertEquals(0.0, retrievedTotalPriceWithoutTax, 0.01);
    }
}