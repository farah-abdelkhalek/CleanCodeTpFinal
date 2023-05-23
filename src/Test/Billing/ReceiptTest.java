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
        productsList.add(new Products("Product 1", 10.0, false, "Category 1"));
        productsList.add(new Products("Product 2", 20.0, true, "Category 2"));
        productsList.add(new Products("Product 3", 30.0, false, "Category 3"));

        totalTax = 15.0;
        totalPriceWithTax = 75.0;

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