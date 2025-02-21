//Aim- write a java program to implement an arraylist that store employee details(ID,Name,Salary), allow user to add update , remove and search employees.
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    // Constructor to initialize employee details
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to add a new employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employeeList.add(employee);
        System.out.println("Employee added successfully!");
    }

    // Method to update an existing employee
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Employee employee : employeeList) {
            if (employee.id == id) {
                found = true;
                scanner.nextLine();  // Consume newline left-over
                System.out.print("Enter new Name: ");
                employee.name = scanner.nextLine();
                System.out.print("Enter new Salary: ");
                employee.salary = scanner.nextDouble();
                System.out.println("Employee details updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Method to remove an employee by ID
    public static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;

        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employeeList.remove(employee);
                removed = true;
                System.out.println("Employee removed successfully!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Method to search for an employee by ID
    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employee.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Method to display all employees
    public static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employeeList) {
                employee.display();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
