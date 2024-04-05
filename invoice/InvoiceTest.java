package Invoice;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {
    public InvoiceTest() {}
    @Test
    /*jak sie nad tym zastanowic, test sprawdza czy wszystkie pola sa poprawnie zainicjalizowane przez konstruktor,
    wiec na dobra sprawe jest to test jednostkowy*/
    public void testConstruktor() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, 42.00);
        System.out.format("Produkt " + sut.getProductDescription() + " o numerze: " + sut.getPRODUCT_NUMBER() + """
                """ + "; ilość (" + sut.getQuantity() + """
                ) * cena (%.2f) daje kwote: %.2f \nNie wykryto bledow przy tworzeniu egzemplarza""", sut.getPricePerItem(), sut.amount());
    }
    @Test
    public void testSetDescription() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, 42.00);
        sut.setProductDescription("lorem ipsum");
        Assert.assertEquals("lorem ipsum", sut.getProductDescription());
    }
    @Test
    public void testSetQuantity() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, 42.00);
        sut.setQuantity(3);
        Assert.assertEquals(3, sut.getQuantity());
    }
    @Test
    public void testSetPricePerItem() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, 42.00);
        sut.setPricePerItem(1.00);
        Assert.assertEquals(1.00, sut.getPricePerItem(), 0);
    }
    @Test
    public void testAmountValid() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, 42.00);
        Assert.assertEquals(84.00, sut.amount(), 0);
    }
    @Test
    public void testAmountNegativeQuantity() {
        Invoice sut = new Invoice("3248", "lolem xdum", -2, 42.00);
        Assert.assertEquals(0.00, sut.amount(), 0);
    }
    @Test
    public void testAmountNagativePrice() {
        Invoice sut = new Invoice("3248", "lolem xdum", 2, -42.00);
        Assert.assertEquals(0.00, sut.amount(), 0);
    }
    @Test
    public void testAmountNegativeBoth() {
        Invoice sut = new Invoice("3248", "lolem xdum", -2, -42.00);
        Assert.assertEquals(0.00, sut.amount(), 0);
    }
}
