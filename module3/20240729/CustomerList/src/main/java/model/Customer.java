package model;

public class Customer {
    private int id;
    private final String name;
    private final String dob;
    private final String address;
    private final String imgURL;
    public Customer(String name, String dob, String address, String imgURL) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.imgURL = imgURL;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getName() {
        return name;
    }
}
