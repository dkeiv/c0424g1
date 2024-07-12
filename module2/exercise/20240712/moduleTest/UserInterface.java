import com.sun.org.apache.xerces.internal.dom.AbortException;
import phone.AuthenticPhone;
import phone.HandGoodPhone;
import phone.Phone;

import java.util.List;
import java.util.Scanner;

public class UserInterface implements Constants {
    private final Scanner scanner;
    private final PhoneManager phoneManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.phoneManager = new PhoneManager();
    }

    public void start() {
        boolean running = true;

        this.phoneManager.loadAuthentic();
        this.phoneManager.loadHandleGood();
        while (running) {
            try {
                printMenu();
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {

                    case ADD:
                        add();
                        break;
                    case REMOVE:
                        remove();
                        break;
                    case SHOW:
                        show();
                        break;
                    case SEARCH:
                        search();
                        break;
                    case EXIT:
                        running = false;
                        break;
                    default:
                        break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("bye bye");
    }

    private void add() {
        printPhoneTypeMenu();

        try {

            System.out.print("type: ");
            String type = scanner.nextLine();
            this.phoneManager.isValidType(type);

            System.out.print("name: ");
            String name = scanner.nextLine();

            System.out.print("price: ");
            double price = Double.parseDouble(scanner.nextLine());
            this.phoneManager.isValidPrice(price);

            System.out.print("quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            this.phoneManager.isValidQuantity(quantity);

            System.out.print("manufacturer: ");
            String manufacturer = scanner.nextLine();

            if (type.equals("authentic")) {
                System.out.print("insurance day: ");
                int insurance = Integer.parseInt(scanner.nextLine());
                this.phoneManager.isValidInsuranceDay(insurance);

                System.out.print("scope: ");
                String scope = scanner.nextLine();
                this.phoneManager.isValidScope(scope);

                int id = this.phoneManager.getMaxId();

                Phone phone = new AuthenticPhone(id, name, price, quantity, manufacturer, insurance, scope);
                phoneManager.addPhone(phone);
                this.phoneManager.saveAuthentic();

            } else if (type.equals("hand good")) {
                System.out.print("country: ");
                String country = scanner.nextLine();
                this.phoneManager.isValidCountry(country);

                System.out.print("status: ");
                String status = scanner.nextLine();
                this.phoneManager.isValidStatus(status);

                int id = this.phoneManager.getMaxId();

                Phone phone = new HandGoodPhone(id, name, price, quantity, manufacturer, country, status);
                phoneManager.addPhone(phone);
                this.phoneManager.saveHandGood();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void remove() {
        try {
            System.out.print("Nhap id: ");
            int id = Integer.parseInt(scanner.nextLine());

            Phone phone = this.phoneManager.getPhone(id);

            if (phone == null) {
                throw new Exception("Invalid id");
            }

            System.out.println("are you sure you want to delete? ([yes/y] to confirm else to cancel)");
            String answer = this.scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes") || answer.equals("y")) {
                this.phoneManager.removePhone(phone);
                if (phone instanceof AuthenticPhone) {
                    this.phoneManager.saveAuthentic();
                }
                if (phone instanceof HandGoodPhone) {
                    this.phoneManager.saveHandGood();
                }
            }

            show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void show() {
        for (Phone phone : this.phoneManager.asCollection()) {
            System.out.println(phone);
        }
    }

    private void search() {
        System.out.print("Nhap ten dien thoai: ");
        String name = scanner.nextLine();

        List<Phone> phoneList = this.phoneManager.searchByName(name);
        if (phoneList.isEmpty()) {
            System.out.println("No result found");
        }
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }


    private void printPhoneTypeMenu() {
        System.out.println("authentic");
        System.out.println("hand good");
    }

    private void printMenu() {
        System.out.println("Chuong trinh quan li dien thoai");
        System.out.println("Chon chuc nang theo so (de tiep tuc):");
        System.out.println("1. Them moi");
        System.out.println("2. Xoa");
        System.out.println("3. Xem danh sach dien thoai");
        System.out.println("4. Tim kiem");
        System.out.println("5. Thoat");
        System.out.print("Chon chuc nang: ");
    }
}
