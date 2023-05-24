package Billing;

import static Billing.ReceiptDisplayer.displayReceipt;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReceiptDisplayerTest {

    private List<Products> productsList;
    private double totalTax;
    private double totalPriceWithTax;
    private Receipt receipt;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    @Before
    public void setup() {

        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void testDisplayTotal() {
        String label = "Total Price (Without Tax):";
        double amount = 10.0;

        ReceiptDisplayer.displayTotal(label, amount);

        String expectedOutput = "Total Price (Without Tax):\r\n10,00€\r\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    private Receipt createSampleReceipt() {
        List<Products> productList = new ArrayList<>();
        productList.add(new Products("Perfume", 27.99, true, "Cosmetic"));
        productList.add(new Products("PillsAgainstMigraines", 9.75, false, "Medecine"));
        double totalTax = 4.20;
        double totalPriceWithTax = 42.0;
        return new Receipt(productList, totalTax, totalPriceWithTax);
    }

    private Map<Products, Integer> createSampleProductCountMap() {
        Map<Products, Integer> productCountMap = new HashMap<>();
        productCountMap.put(new Products("Perfume", 18.99, false, "Cosmetic"), 2);
        productCountMap.put(new Products("PillsAgainstMigraines", 9.75, false, "Medecine"), 1);
        return productCountMap;
    }

    @Test
    public void testDisplayReceipt() {
        Receipt receipt = createSampleReceipt();

        ReceiptDisplayer.displayReceipt(receipt);

        String expectedOutput = "----- Receipt -----\n\r" +
                "\nProduct List:\r\n" +
                "Product 2 (x1)\r\n" +
                "Product 1 (x1)\r\n" +
                "\nTotal Price (Without Tax):0.0\r\n" +
                "\nTotal Price (With Tax):15.0\r\n" +
                "Total Price (Without Tax):\r\n" +
                "0,00€\r\n" +
                "Total Tax:\r\n" +
                "5,00€\r\n" +
                "Total Price (With Tax):\r\n" +
                "15,00€\r\n\r\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}





