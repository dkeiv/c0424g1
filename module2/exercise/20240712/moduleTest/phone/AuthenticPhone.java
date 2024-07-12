package phone;

public class AuthenticPhone extends Phone {
    private int insuranceDay;
    private String scope;

    public AuthenticPhone(int id, String name, double price, int quantity, String manufacturer, int insuranceDay, String scope) {
        super(id, name, price, quantity, manufacturer);
        this.insuranceDay = insuranceDay;
        this.scope = scope;
    }

    public int getInsurance() {
        return insuranceDay;
    }

    public void setInsurance(int insuranceDay) {
        this.insuranceDay = insuranceDay;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String toCSVLine() {
        return super.toCSVLine() + ","
                + this.insuranceDay + ","
                + this.scope;
    }

    @Override
    public String toString() {
        return super.toString() + "," + "Insurance day: " + this.insuranceDay + "," + "scope: " + this.scope;
    }
}
