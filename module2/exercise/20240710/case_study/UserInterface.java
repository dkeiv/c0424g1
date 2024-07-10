import item.Food;
import manager.MenuManager;

import java.util.*;

public class UserInterface implements Constants {
    private final Scanner scanner;
    private final MenuManager menuManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.menuManager = new MenuManager();
    }

    public void start() {
        boolean running = true;

        this.menuManager.loadFromFile();

        while (running) {
            printMenu();
            System.out.print("command: ");
            String command = this.scanner.nextLine();

            switch (command) {
                case EXIT:
                    running = false;
                    break;
                case ADD:
                    add();
                    break;
                case EDIT:
                    edit();
                    break;
                case SHOW:
                    show();
                    break;
                case DELETE:
                    delete();
                    break;
                case SEARCH:
                    search();
                    break;
                case SORT:
                    printSortedMenu();
                    break;
                default:
                    System.out.println(INVALID_COMMAND);
                    break;
            }
        }

        scanner.close();
        System.out.println("bye bye~");
    }

    private void printSortedMenu() {
        LinkedHashMap<String, Food> sorted = menuManager.sortByValue();

        for (Food food : sorted.values()) {
            System.out.println(food);
        }
    }

    private void add() {
        printTypeMenu();

        System.out.print("type: ");
        String type = scanner.nextLine();

        if (!isValidType(type)) {
            throw new IllegalArgumentException(INVALID_TYPE);
        }

        try {
            System.out.print("code: ");
            String code = scanner.nextLine();
            menuManager.isUnique(code);
            System.out.print("name: ");
            String name = scanner.nextLine();
            System.out.print("description: ");
            String description = scanner.nextLine();
            System.out.print("price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Food newFood = new Food(code, name, type, price, description, quantity);
            this.menuManager.addFood(newFood);
            this.menuManager.saveToFile();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void delete() {
        System.out.print("code: ");
        String code = scanner.nextLine();

        Food food = this.menuManager.getFoodByCode(code);

        if (food == null) {
            throw new IllegalArgumentException(INVALID_CODE + ": " + code);
        }

        System.out.println(CONFIRM_MESSAGE);
        String answer = this.scanner.nextLine().trim().toLowerCase();

        if (answer.equals("y") || answer.equals("yes")) {
            this.menuManager.removeFood(food);
            this.menuManager.saveToFile();
        }
    }

    private void edit() {
        System.out.print("code: ");
        String code = scanner.nextLine();

        Food food = menuManager.getFoodByCode(code);
        if (food == null) {
            throw new IllegalArgumentException(INVALID_CODE + ": " + code);
        }

        try {
            System.out.print("name: ");
            String name = scanner.nextLine();
            if (name != null && !name.isEmpty()) {
                food.setName(name);
            }

            System.out.print("description: ");
            String description = scanner.nextLine();
            if (description != null && !description.isEmpty()) {
                food.setDescription(description);
            }

            System.out.print("price: ");
            double price = Double.parseDouble(scanner.nextLine());
            if (price != 0) {
                food.setPrice(price);
            }

            this.menuManager.saveToFile();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println(ADD);
        System.out.println(EDIT);
        System.out.println(SHOW);
        System.out.println(DELETE);
        System.out.println(SEARCH);
        System.out.println(SORT);
        System.out.println(EXIT);
    }

    private void show() {
        printTypeMenu();
        System.out.println("all");
        System.out.print("type: ");
        String type = this.scanner.nextLine();

        if (type.equals("all")) {
            this.menuManager.displayMenu();
        }

        if (isValidType(type)) {
            this.menuManager.displayMenu(type);
        }
    }

    public void search() {
        System.out.print("name: ");
        String name = scanner.nextLine();
        Map<String, Food> result = menuManager.searchByName(name);

        if (result.isEmpty()) {
            System.out.println(EMPTY);
        } else {
            for (Food food : result.values()) {
                System.out.println(food);
            }
        }

    }

    private static void printTypeMenu() {
        System.out.println(COFFEE);
        System.out.println(TEA);
        System.out.println(JUICE);
        System.out.println(SNACK);
    }

    private boolean isValidType(String type) {
        return type.equals(COFFEE) ||
                type.equals(TEA) ||
                type.equals(JUICE) ||
                type.equals(SNACK);
    }
}
