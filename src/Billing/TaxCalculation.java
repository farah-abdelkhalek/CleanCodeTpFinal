package Billing;

import java.util.List;

public class TaxCalculation {
     private static final String FOOD = "Food";
     private static final String MEDICINE = "Medicine";
     private static final String BOOK = "Book";

     public double calculateTaxAmount(List<Products> products) {
         double totalTaxAmount = 0;

         for (Products product : products) {
             double taxAmount = getTaxAmount(product);
             totalTaxAmount += taxAmount;
         }

         return totalTaxAmount;
     }

     public double getTaxAmount(Products product) {
         double taxAmount = 0;

         if (!isTaxExempt(product)) {
             TaxSystem taxSystem = getTaxSystem(product);
             taxAmount = taxSystem.calculateTax(product);
         }

         return taxAmount;
     }

     boolean isTaxExempt(Products product) {
         String category = product.getCategory();
         return category.equals(FOOD) || category.equals(MEDICINE) || category.equals(BOOK);
     }

     TaxSystem getTaxSystem(Products product) {
         if (product.getIsImported()) {
             return TaxSystem.IMPORTED_TAX;
         } else {
             return TaxSystem.TAX;
            }
     }
}


