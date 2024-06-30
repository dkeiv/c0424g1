import java.util.Scanner;

public class UserInterface {
    private final String fileName = "data.txt";
    private final Scanner scanner;
    private final StudentManager sm;


    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.sm = new StudentManager();
    }


    public void start() {
        this.loadFromFile(this.fileName);

        label:
        while (true) {
            this.printMenu();
            System.out.print("command: ");
            String command = this.scanner.nextLine();

            switch (command) {
                case "exit":
                    break label;
                case "add":
                    this.add();
                    break;
                case "show":
                    this.show();
                    break;
                case "delete":
                    this.delete();
                    break;
                case "export":
                    this.export();
                    break;
                case "import":
                    this.importFromFile();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        System.out.println("Exiting program...");
    }

    private void add() {
        System.out.print("id: ");
        int id = Integer.parseInt(this.scanner.nextLine());
        System.out.print("name: ");
        String name = this.scanner.nextLine();
        System.out.print("age: ");
        int age = Integer.parseInt(this.scanner.nextLine());

        Student newStudent = new Student(id, name, age);
        this.sm.addStudent(newStudent);

        // save to file
        this.saveToFile(this.fileName);
    }

    private void show() {
        if (this.sm.numberOfStudent() <= 0) {
            System.out.println("Nothing to show");
        }
        this.sm.showStudentList();
    }

    private void delete() {
        System.out.print("id :");
        int id = Integer.parseInt(this.scanner.nextLine());

        Student student = this.sm.getStudentById(id);

        if (student == null) {
            System.out.println("Student not found");
        } else {
            this.sm.delete(student);
            saveToFile(this.fileName);
        }
    }

    private void export() {
        System.out.print("Export to file: ");
        String filename = this.scanner.nextLine();
        this.saveToFile(filename);
    }

    private void importFromFile() {
        System.out.print("Import from file: ");
        String filename = this.scanner.nextLine();
        loadFromFile(filename);
        saveToFile(this.fileName);
    }

    private void loadFromFile(String fileName) {
        this.sm.loadFromFile(fileName);
    }

    private void saveToFile(String fileName) {
        this.sm.saveToFile(fileName);
    }

    private void printMenu() {
        System.out.println("add");
        System.out.println("show");
        System.out.println("delete");
        System.out.println("export");
        System.out.println("import");
        System.out.println("exit");
    }
}
