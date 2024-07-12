package phone;

public class HandGoodPhone extends Phone {
    private String country;
    private String status;

    public HandGoodPhone(int id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toCSVLine() {
        return super.toCSVLine() + "," + this.country + "," + this.status;
    }

    public String toString() {
        return super.toString() + "," + "country: " + this.country + "," + "status: " + this.status;
    }
}
