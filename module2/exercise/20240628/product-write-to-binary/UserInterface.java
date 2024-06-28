import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final String fileName = "data.bin";
    private final Scanner scanner;
    private final ProductManager pm;


    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.pm = new ProductManager();
    }


    public void start() {
        this.loadFromFile();

        while (true) {
            this.printMenu();
            System.out.print("command: ");
            String command = this.scanner.nextLine();

            if (command.equals("exit")) {
                break;
            } else if (command.equals("add")) {
                this.add();
            } else if (command.equals("show")) {
                this.show();
            } else if (command.equals("search")) {
                this.search();
            } else {
                System.out.println("Invalid command");
            }
        }
        System.out.println("Exiting program...");
    }

    private void add() {
        System.out.print("code :");
        String code = this.scanner.nextLine();
        System.out.print("name: ");
        String name = this.scanner.nextLine();
        System.out.print("price: ");
        double price = this.scanner.nextDouble();

        Product newProduct = new Product(code, name, price);
        this.pm.addProduct(newProduct);

        // save to file
        this.saveToFile();
    }

    private void show() {
        if (this.pm.numberOfProducts() <= 0) {
            System.out.println("Nothing to show");
        }
        this.pm.showProductList();
    }

    private void search() {
        System.out.print("code :");
        String code = this.scanner.nextLine();

        Product product = this.pm.getProductByCode(code);

        if (product == null) {
            System.out.println("Product not found");
        } else {
            System.out.println(product);
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = new FileInputStream(this.fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Product> productList = (List<Product>) ois.readObject();
            this.pm.setProducts(productList);

            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println("Exception in loading from file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(this.fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.pm.getProducts());

            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Exception in saving to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void printMenu() {
        System.out.println("add");
        System.out.println("show");
        System.out.println("search");
        System.out.println("exit");
    }
}
