package manager;
import employee.*;

public class EmployeeManager {
    private int numberOfEmployee = 0;
    private int numberOfOfficeEmployee = 0;
    private int numberOfFactoryEmployee = 0;
    private int numberOfDeliveryEmployee = 0;
    private final Employee[] employees;
    private final int limit;

    public EmployeeManager(int limit) {
        this.employees = new Employee[limit];
        this.limit = limit;
    }

    private void updateNumberOfEmployee(Employee employee, int amount) {
        if (employee instanceof OfficeEmployee) {
            this.numberOfOfficeEmployee += amount;
        }
        if (employee instanceof FactoryEmployee) {
            this.numberOfFactoryEmployee += amount;
        }
        if (employee instanceof DeliveryEmployee) {
            this.numberOfDeliveryEmployee += amount;
        }

        this.numberOfEmployee
                = this.numberOfOfficeEmployee
                + this.numberOfFactoryEmployee
                + this.numberOfDeliveryEmployee;
    }

    public void addEmployee(Employee employee) {

        if (this.numberOfEmployee >= this.limit) {
            return;
        }

        this.employees[this.numberOfEmployee] = employee;

        this.updateNumberOfEmployee(employee, 1);
    }

    public void remove(Employee employee) {
        Employee[] newEmployees = new Employee[this.limit];

        for (int i = 0, j = 0; i < this.numberOfEmployee; i++, j++) {
            if (employee.getId() == this.employees[i].getId()) {
                j--;
                continue;
            }
            newEmployees[i] = this.employees[i];
        }

        System.arraycopy(newEmployees, 0, this.employees, 0, this.numberOfOfficeEmployee);
        this.updateNumberOfEmployee(employee, -1);
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < this.numberOfOfficeEmployee; i++) {
            if (this.employees[i].getId() == id) {
                return this.employees[i];
            }
        }
        return null;
    }

    public void showAllEmployee() {
        System.out.println("Employees: " + this.numberOfEmployee);
        for (int i = 0; i < this.numberOfEmployee; i++) {
            System.out.println(this.employees[i]);
        }
    }

    public void showOfficeEmployee() {
        System.out.println("Office employees: " + this.numberOfOfficeEmployee);
        for (Employee employee : employees) {
            if (employee instanceof OfficeEmployee) {
                System.out.println(employee);
            }
        }
    }

    public void showFactoryEmployee() {
        System.out.println("Factory Employees: " + this.numberOfFactoryEmployee);
        for (Employee employee : employees) {
            if (employee instanceof FactoryEmployee) {
                System.out.println(employee);
            }
        }
    }

    public void showDeliveryEmployee() {
        System.out.println("Delivery employees: " + this.numberOfDeliveryEmployee);
        for (Employee employee : employees) {
            if (employee instanceof DeliveryEmployee) {
                System.out.println(employee);
            }
        }
    }
}
