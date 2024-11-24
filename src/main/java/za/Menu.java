package za;

import za.database_related.SearchDatabase;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static SearchDatabase searchDatabase = new SearchDatabase();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserInput("Please choose an option: ");
            switch (choice) {
                case 1:
                    searchByDepartment();
                    break;
                case 2:
                    searchByRole();
                    break;
                case 3:
                    searchByPersonName();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    searchByEmail();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Employee Search System ---");
        System.out.println("1. Search by Department");
        System.out.println("2. Search by Role");
        System.out.println("3. Search by Name");
        System.out.println("4. Search by ID Number");
        System.out.println("5. Search by Email");
        System.out.println("6. Exit");
    }

    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static void searchByDepartment() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter department name: ");
        String departmentName = scanner.nextLine();
        searchDatabase.searchByDepartment(departmentName);
    }

    private static void searchByRole() {
        scanner.nextLine();
        System.out.print("Enter role name: ");
        String roleName = scanner.nextLine();
        searchDatabase.searchByRole(roleName);
    }

    private static void searchByPersonName() {
        scanner.nextLine();
        System.out.print("Enter person's first or last name: ");
        String name = scanner.nextLine();
        searchDatabase.searchByName(name);
    }

    private static void searchById() {
        System.out.print("Enter ID number: ");
        String id = scanner.next();
        searchDatabase.searchByIdNumber(id);
    }

    private static void searchByEmail() {
        scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        searchDatabase.searchByEmail(email);
    }
}
