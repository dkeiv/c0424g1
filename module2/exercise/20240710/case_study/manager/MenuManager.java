package manager;

import item.Food;
import utilis.PriceComparator;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class MenuManager {
    private final Map<String, Food> foodMap;

    public MenuManager() {
        this.foodMap = new HashMap<String, Food>();
    }

    public void addFood(Food food) {
        if (foodMap.containsKey(food.getCode())) {
            this.foodMap.get(food.getCode()).increaseQuantity();
        }
        this.foodMap.put(food.getCode(), food);
    }

    public void removeFood(Food food) {
        this.foodMap.remove(food.getCode());
    }

    public Food getFoodByCode(String code) {
        return this.foodMap.get(code);
    }

    public Map<String, Food> searchByName(String name) {
        Map<String, Food> result = new HashMap<>();
        for (Food food : this.foodMap.values()) {
            if (food.getName().contains(name)) {
                result.put(food.getCode(), food);
            }
        }
        return result;
    }

    public Map<String, Food> searchByType(String type) {
        Map<String, Food> result = new HashMap<>();
        for (Food food : asCollection()) {
            if (food.getType().contains(type)) {
                result.put(food.getCode(), food);
            }
        }
        return result;
    }

    public void removeALlType(String type) {
        Set<String> deletedKeys = new HashSet<>();

        for (Food food : asCollection()) {
            if (food.getType().contains(type)) {
                deletedKeys.add(food.getCode());
            }
        }

        this.foodMap.keySet().removeAll(deletedKeys);
    }

    public void displayMenu() {
        if (this.foodMap.isEmpty()) {
            System.out.println("No food found");
            return;
        }

        String item = " item";
        if (this.totalItem() > 1) {
            item = " items";
        }

        for (Food food : asCollection()) {
            System.out.println(food);
        }
        System.out.println("Total: " + this.totalItem() + item);
    }

    public void displayMenu(String type) {
        if (this.foodMap.isEmpty()) {
            System.out.println("No food found");
            return;
        }

        for (Food food : asCollection()) {
            if (food.getType().contains(type)) {
                System.out.println(food);
            }
        }
    }

//    public HashMap<String, Food> sortByValue() {
//        HashMap<String, Food> temp = this.foodMap.entrySet()
//                .stream()
//                .sorted((i1, i2)
//                        -> i1.getValue().compareTo(
//                        i2.getValue()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//        return temp;
//    }

    public LinkedHashMap<String, Food> sortByValue() {
        LinkedHashMap<String, Food> result = new LinkedHashMap<>();
        ArrayList<Food> list = new ArrayList<>(this.foodMap.values());
        PriceComparator comparator = new PriceComparator();
        list.sort(comparator);

        for (Food food : list) {
            result.put(food.getCode(), food);
        }

        return result;
    }

    public void isUnique(String code) throws Exception {
        if (foodMap.containsKey(code)) {
            throw new Exception();
        }
    }

    public int totalItem() {
        return this.foodMap.size();
    }

    private Collection<Food> asCollection() {
        return this.foodMap.values();
    }

    public void saveToFile() {
        try {
            String fileName = "data.txt";
            FileWriter myWriter = new FileWriter(fileName);
            for (Food food : this.asCollection()) {
                myWriter.write(food.toCSVLine() + "\n");
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Exception in saving to file: " + e.getMessage());
//            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {

            String fileName = "data.txt";
            ArrayList<String[]> buffer = new ArrayList<>();
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                buffer.add(line);
            }

            reader.close();

            for (String[] line : buffer) {
                String code = line[0];
                String name = line[1];
                String type = line[2];
                double price = Double.parseDouble(line[3]);
                String description = line[4];
                int quantity = Integer.parseInt(line[5]);

                Food food = new Food(code, name, type, price, description, quantity);

                this.addFood(food);
            }

        } catch (Exception e) {
            System.out.println("Exception in loading from file: " + e.getMessage());
        }
    }
}
