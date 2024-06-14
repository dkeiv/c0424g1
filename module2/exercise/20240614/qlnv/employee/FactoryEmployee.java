package employee;

public class FactoryEmployee extends Employee {
    private int factoryID;
    private String type;

    public FactoryEmployee(int id, String name, String phone, String position, int factoryId, String type) {
        setId(id);
        setName(name);
        setPhone(phone);
        setPosition(position);
        this.factoryID = factoryId;
        this.type = type;
    }

    public FactoryEmployee(int id, String name) {
        this(id, name, null, null, 0, null);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(int factoryID) {
        this.factoryID = factoryID;
    }

    @Override
    public String toString() {
        return super.toString() + "FactoryEmployee{" +
                "factoryID=" + factoryID +
                ", type='" + type + '\'' +
                '}';
    }
}
