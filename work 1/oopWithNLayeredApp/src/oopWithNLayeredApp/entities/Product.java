package oopWithNLayeredApp.entities;

public class Product {
    private int id;
    private String Name;
    private double unitPrice;

    public Product() {
    }

    public Product(int id, String name, double unitPrice) {
        this.id = id;
        Name = name;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Product setName(String name) {
        Name = name;
        return this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Product setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }
}
