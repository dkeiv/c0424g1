package utilis;

import item.Food;

import java.util.Comparator;

public class PriceComparator implements Comparator<Food> {
    @Override
    public int compare(Food food1, Food food2) {
        return Double.compare(food1.getPrice(), food2.getPrice());
    }
}
