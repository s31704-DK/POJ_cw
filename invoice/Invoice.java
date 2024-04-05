package Invoice;

public class Invoice {
    private final String PRODUCT_NUMBER;    //podane przy tworzeniu egzemplarza, zmiana jest niepożądana
    private String productDescription;
    private int quantity;
    private double pricePerItem;
    //konstruktor
    public Invoice(String PRODUCT_NUMBER, String productDescription, int quantity, double pricePerItem) {
        this.PRODUCT_NUMBER = PRODUCT_NUMBER;
        this.productDescription = productDescription;
        this.quantity = quantity;           //nie spotkalem sie z ujemna iloscia nawet na fakturach korygujacych, ale skoro tresc zadania przewiduje, to ide za ciosem
        this.pricePerItem = pricePerItem;
    }
    //gettery
    public String getPRODUCT_NUMBER() {
        return PRODUCT_NUMBER;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPricePerItem() {
        return pricePerItem;
    }
    //settery
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
    //metody
    public double amount() {
        if (pricePerItem < 0 || quantity < 0) {
            return 0;
        } else {
            return quantity * pricePerItem;
        }
    }
}
