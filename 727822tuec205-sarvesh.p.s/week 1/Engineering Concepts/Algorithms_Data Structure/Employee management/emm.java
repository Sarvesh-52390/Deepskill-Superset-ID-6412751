class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

public class emm{
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice", "Developer", 75000));
        manager.addEmployee(new Employee(102, "Bob", "Designer", 65000));
        manager.addEmployee(new Employee(103, "Charlie", "Manager", 85000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee ID 102:");
        Employee found = manager.searchEmployee(102);
        if (found != null) {
            found.display();
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee ID 101:");
        manager.deleteEmployee(101);

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}
