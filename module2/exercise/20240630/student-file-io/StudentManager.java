import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private final List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int numberOfStudent() {
        return this.students.size();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void showStudentList() {
        for (Student product : this.students) {
            System.out.println(product);
        }
    }

    public Student getStudentById(int studentId) {
        for (Student student : this.students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void delete(Student student) {
        this.students.remove(student);
    }

    public void loadFromFile(String fileName) {
        try {
            ArrayList<String[]> buffer = new ArrayList<>();
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                buffer.add(line);
            }

            reader.close();

            for (String[] line : buffer) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                Student student = new Student(id, name, age);
                this.addStudent(student);
            }


        } catch (Exception e) {
            System.out.println("Exception in loading from file: " + e.getMessage());
        }
    }

    public void saveToFile(String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for(Student student : this.students) {
                myWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "\n");
            }
            myWriter.close();

        } catch (Exception e) {
            System.out.println("Exception in saving to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
