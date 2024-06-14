package employee;
public class OfficeEmployee extends Employee {
    public OfficeEmployee(int id, String name, String phone, String position) {
        setId(id);
        setName(name);
        setPhone(phone);
        setPosition(position);
    }

    public OfficeEmployee(int id, String name) {
        this(id,name,null,null);
    }
}
