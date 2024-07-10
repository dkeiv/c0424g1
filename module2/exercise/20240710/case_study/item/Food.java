package item;

import java.util.Objects;

public class Food implements Comparable<Food> {
      private final String code;
    private String name;
    private String type;
    private double price;
    private String description;
    private int quantity;

    public Food(String code, String name, String type, double price, String description, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
    }

    public void reduceQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toCSVLine() {
        return this.code + "," + this.name + "," + this.type + "," + this.price + "," + this.description + "," + this.quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Food obj) {
        return Double.compare(this.price, obj.price);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Food food = (Food) object;
        return Double.compare(price, food.price) == 0 &&
                quantity == food.quantity &&
                Objects.equals(code, food.code) &&
                Objects.equals(name, food.name) &&
                Objects.equals(type, food.type) &&
                Objects.equals(description, food.description);
    }
}