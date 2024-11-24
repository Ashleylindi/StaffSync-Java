package za;

import za.database_related.UseDatabase;
import za.person_related.Person;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;


        // Display options to the user
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Delete Employee");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Add Employee using the Person class
                    try {
                        System.out.print("Enter first name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter ID number: ");
                        String idNumber = scanner.nextLine();

                        // Create a new Person object
                        Person person = new Person(firstName, lastName, email, idNumber);

                        // Display the details of the person object
                        System.out.println("Employee details: " + person);

                        // View departments before asking for a department choice
                        System.out.println("\nDepartments:");
                        UseDatabase.getAllDepartments();
                        System.out.print("Enter department ID: ");
                        int departmentId = scanner.nextInt();

                        // View roles before asking for a role choice
                        System.out.println("\nRoles:");
                        UseDatabase.getAllRoles();
                        System.out.print("Enter role ID: ");
                        int roleId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        // Now you can use the Person details to add the employee
                        UseDatabase.addEmployee(person.getFirstName(), person.getLastName(),
                                person.getEmail(), person.getIdNumber(), person.getDateOfBirth(),
                                person.getGender(), person.getCitizenship(), person.getAge(), departmentId, roleId);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    // View All Employees
                    System.out.println("\nEmployees:");
                    UseDatabase.getAllEmployees();
                    break;
                case 3:
                    // Delete Employee
                    System.out.print("Enter employee ID to delete: ");
                    int empIdToDelete = scanner.nextInt();
                    UseDatabase.deleteEmployee(empIdToDelete);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
