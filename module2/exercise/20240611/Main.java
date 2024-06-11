import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager sm = new StudentManager(10);

        while (true) {
            printMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    sm.showStudent();
                    break;
                case 2:
                    handleAdd(scanner, sm);
                    break;
                case 3:
                    handleEdit(scanner, sm);
                    break;
                case 4:
                    handleDelete(scanner, sm);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Hien thi ds.");
        System.out.println("2. Them sv.");
        System.out.println("3. Sua sv.");
        System.out.println("4. Xoa sv.");
        System.out.println("0. Exit");
    }

    public static void handleAdd(Scanner scanner, StudentManager sm) {
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student newStudent = new Student(name, id);
        sm.addStudent(newStudent);
    }

    public static void handleEdit(Scanner scanner, StudentManager sm) {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = sm.getStudentById(id);

        if (student == null) {
            System.out.println("Ko co sv");
            return;
        }

        System.out.println("Ten moi: ");
        String name = scanner.nextLine();
        student.setName(name);
    }

    public static void handleDelete(Scanner scanner, StudentManager sm) {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = sm.getStudentById(id);

        if (student == null) {
            System.out.println("Ko co sv");
            return;
        }

        sm.removeStudent(student);
    }

}