public class StudentManager {
    protected Student[] listStudent;
    protected int limit;
    protected int size;

    public StudentManager(int limit) {
        this.listStudent = new Student[limit];
        this.limit = limit;
        this.size = 0;
    }

    public void addStudent(Student student) {
        if (this.size == this.limit) {
            System.out.println("Student full");
            return;
        }
        listStudent[this.size] = student;
        this.size++;
    }

    public Student getStudentById(int id) {
        for (int i = 0; i < this.size; i++) {
            if (this.listStudent[i].getId() == id) {
                return this.listStudent[i];
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        Student[] newList = new Student[this.limit];

        for (int i = 0, j = 0; i < this.size; i++, j++) {
            if (this.listStudent[i].getId() == student.getId()) {
                j--;
                continue;
            }
            newList[j] = this.listStudent[i];
        }

        System.arraycopy(newList, 0, this.listStudent, 0, this.limit);
    }

    public void showStudent() {
        if (this.size == 0) {
            System.out.println("Student empty");
            return;
        }
        for (int i = 0; i < this.size; i++) {
            System.out.println(listStudent[i]);
        }
    }
}