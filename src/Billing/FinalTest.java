package Billing;

import Billing.Products;
import Billing.Receipt;
import Billing.ReceiptDisplayer;
import Billing.ReceiptGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalTest {
    public static class EndTest {
        public static void main(String[] args) {
            List<Products> productList = getProductListFromUser();
            Receipt receipt = ReceiptGenerator.generateReceipt(productList);
            ReceiptDisplayer.displayReceipt(receipt);
        }

        private static List<Products> getProductListFromUser() {
            List<Products> productList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            String addProductChoice = "y";
            while (addProductChoice.equalsIgnoreCase("y")) {
                System.out.println("Enter product name:");
                String name = scanner.nextLine();

                System.out.println("Enter product price:");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter import status (true/false):");
                boolean importStatus = scanner.nextBoolean();
                scanner.nextLine();

                System.out.println("Enter product category:");
                String category = scanner.nextLine();

                Products product = new Products(name, price, importStatus, category);
                productList.add(product);

                System.out.println("Do you want to add another product? (y/n):");
                addProductChoice = scanner.nextLine();
            }

            return productList;
        }
    }

}
