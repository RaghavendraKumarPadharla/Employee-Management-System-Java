import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Thank you! Application Closed.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!");
    }

    static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            System.out.println("--- Employee List ---");
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found: " + e);
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.id == id) {
                iterator.remove();
                System.out.println("Employee Deleted Successfully!");
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }
}
