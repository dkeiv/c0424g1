package employee;

public class DeliveryEmployee extends Employee {
    private String transport;

    public DeliveryEmployee(int id, String name) {
        setId(id);
        setName(name);
    }

    public DeliveryEmployee(int id, String name, String transport) {
        this(id, name);
        this.transport = transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransport() {
        return transport;
    }

    @Override
    public String toString() {
        return super.toString() + "DeliveryEmployee{" +
                "transport='" + transport + '\'' +
                '}';
    }
}
