package phone;

public abstract class Phone {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;

    public Phone(int id, String name, double price, int quantity, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toCSVLine() {
        return this.getId() + ","
                + this.getName() + ","
                + this.getPrice() + ","
                + this.getQuantity() + ","
                + this.getManufacturer();
    }

    public String toString() {
        return "ID: " + this.getId() + ", Name: " + this.getName() + ", Price: " + this.getPrice();
    }
}
