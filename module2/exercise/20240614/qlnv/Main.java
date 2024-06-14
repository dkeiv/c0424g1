import java.util.Scanner;
import manager.EmployeeManager;
import employee.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager em = new EmployeeManager(10);

        while (true) {
            printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 0:
                    sc.close();
                    return;
                case 1:
                    handleShow(em);
                    break;
                case 2:
                    handleAdd(sc, em);
                    break;
                case 3:
                    handleEdit(sc, em);
                    break;
                case 4:
                    handleDelete(sc, em);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Hien thi ds.");
        System.out.println("2. Them nv.");
        System.out.println("3. Sua nv.");
        System.out.println("4. Xoa nv.");
        System.out.println("0. Exit");
    }

    public static void printAddMenu() {
        System.out.println("1. Add Office Employee");
        System.out.println("2. Add Factory Employee");
        System.out.println("3. Add Delivery Employee");
        System.out.println("Press anything else to exit...");
    }

    public static void handleShow(EmployeeManager em) {
        em.showAllEmployee();
        em.showOfficeEmployee();
        em.showFactoryEmployee();
        em.showDeliveryEmployee();
    }

    public static void handleAdd(Scanner sc, EmployeeManager em) {
        printAddMenu();

        int choice = Integer.parseInt(sc.nextLine());
        if(choice < 1 || 3 < choice) {
            return;
        }

        System.out.println("Nhap id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten: ");
        String name = sc.nextLine();

        if (choice == 1) {
            Employee newOfficeEmploy = new OfficeEmployee(id, name);
            em.addEmployee(newOfficeEmploy);

        }

        if (choice == 2) {
            Employee newFactoryEmploy = new FactoryEmployee(id, name);
            em.addEmployee(newFactoryEmploy);
        }

        if (choice == 3) {
            Employee newDeliveryEmploy = new DeliveryEmployee(id, name);
            em.addEmployee(newDeliveryEmploy);
        }
    }

    public static void handleEdit(Scanner sc, EmployeeManager em) {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        Employee employee = em.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Invalid id");
            return;
        }

        System.out.println("Nhap ten moi: ");
        String name = sc.nextLine();
        employee.setName(name);
    }

    public static void handleDelete(Scanner sc, EmployeeManager em) {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        Employee employee = em.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Invalid id");
            return;
        }

        em.remove(employee);
    }
}
