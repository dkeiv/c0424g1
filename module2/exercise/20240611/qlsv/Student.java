public class Student {
    // Khai bao thuoc tinh
    protected int id;
    protected String name;
    protected String email;
    protected double GPA;
    protected String phone;

    // Khai bao phuong thuc
    public Student(String name, int id) {
        this(id, name, "", 0.0, "");
    }

    public Student(
            int id,
            String name,
            String email,
            double GPA,
            String phone
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.GPA = GPA;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", GPA=" + GPA +
                ", phone='" + phone + '\'' +
                '}';
    }
}