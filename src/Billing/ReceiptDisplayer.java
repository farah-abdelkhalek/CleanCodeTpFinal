package Billing;

import java.util.Map;

public class ReceiptDisplayer {
    public static void displayReceipt(Receipt receipt) {
        System.out.println("----- Receipt -----\n");
        displayProductList(receipt.getProductCountMap());
        System.out.println("\nTotal Price (Without Tax):"+ receipt.getTotalPriceWithoutTax());
        System.out.println("\nTotal Price (With Tax):" + receipt.getTotalPriceWithTax());
        displayTotal("Total Price (Without Tax):", receipt.getTotalPriceWithoutTax());
        displayTotal("Total Tax:", receipt.getTotalTax());
        displayTotal("Total Price (With Tax):", receipt.getTotalPriceWithTax());
        System.out.println();
    }

    private static void displayProductList(Map<Products, Integer> productCountMap) {
        System.out.println("Product List:");

        for (Map.Entry<Products, Integer> entry : productCountMap.entrySet()) {
            Products product = entry.getKey();
            int count = entry.getValue();

            System.out.println(product.getName() + " (x" + count + ")");
        }
    }

    static void displayTotal(String label, double amount) {
        System.out.println(label);
        System.out.println(String.format("%.2f€", amount));
    }
}
