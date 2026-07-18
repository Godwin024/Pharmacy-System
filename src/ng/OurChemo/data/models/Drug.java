package ng.OurChemo.data.models;

import java.time.LocalDate;

public class Drug {
    private int id;
    private String name;
    private String brand;
    private LocalDate expiryDate;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
