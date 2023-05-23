package Billing;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ProductsTest {

    @Test
    public void getName() {
        Products perfume = new Products("Perfume", 27.99, true, "Cosmetic");
        Assert.assertEquals("Perfume", perfume.getName());
    }

    @Test
    public void getPrice() {
        Products Perfume = new Products("Perfume", 27.99, true, "Cosmetic");
        Assert.assertEquals(27.99, Perfume.getPrice(), 0.01);
    }

    @Test
    public void getCategory() {
        Products Perfume = new Products("Perfume", 27.99, true, "Cosmetic");
        Assert.assertEquals(true, Perfume.getIsImported());
    }

    @Test
    public void isImported() {
        Products Perfume = new Products("Perfume", 27.99, true, "Cosmetic");
        Assert.assertEquals("Cosmetic", Perfume.getCategory());
    }

}