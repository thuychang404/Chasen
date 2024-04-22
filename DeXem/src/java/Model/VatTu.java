package Model;

public class VatTu
{
    private String id;
    private String name;
    private String amount;
    private float price;
    
    public VatTu() {
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public VatTu(String id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public VatTu(String id, String name, String amount, float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    
}