package za.database_related;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDatabase {

    // Method to search by department name
    public List<String> searchByDepartment(String departmentName) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM person WHERE department_id IN (SELECT id FROM departments WHERE name LIKE ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + departmentName + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String personDetails = "ID: " + rs.getInt("id") + ", First Name: " + rs.getString("first_name") +
                            ", Last Name: " + rs.getString("last_name") + ", Email: " + rs.getString("email");
                    results.add(personDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by department: " + e.getMessage());
        }
        return results;
    }

    // Method to search by role name
    public List<String> searchByRole(String roleName) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM person WHERE role_id IN (SELECT id FROM roles WHERE name LIKE ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + roleName + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String personDetails = "ID: " + rs.getInt("id") + ", First Name: " + rs.getString("first_name") +
                            ", Last Name: " + rs.getString("last_name") + ", Email: " + rs.getString("email");
                    results.add(personDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by role: " + e.getMessage());
        }
        return results;
    }

    // Method to search by person's first name or last name
    public List<String> searchByName(String name) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM person WHERE first_name LIKE ? OR last_name LIKE ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String personDetails = "ID: " + rs.getInt("id") + ", First Name: " + rs.getString("first_name") +
                            ", Last Name: " + rs.getString("last_name") + ", Email: " + rs.getString("email");
                    results.add(personDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by name: " + e.getMessage());
        }
        return results;
    }

    // Method to search by ID number
    public List<String> searchByIdNumber(String idNumber) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM person WHERE id_number LIKE ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + idNumber + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String personDetails = "ID: " + rs.getInt("id") + ", First Name: " + rs.getString("first_name") +
                            ", Last Name: " + rs.getString("last_name") + ", Email: " + rs.getString("email");
                    results.add(personDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by ID number: " + e.getMessage());
        }
        return results;
    }

    // Method to search by email
    public List<String> searchByEmail(String email) {
        List<String> results = new ArrayList<>();
        String query = "SELECT * FROM person WHERE email LIKE ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + email + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String personDetails = "ID: " + rs.getInt("id") + ", First Name: " + rs.getString("first_name") +
                            ", Last Name: " + rs.getString("last_name") + ", Email: " + rs.getString("email");
                    results.add(personDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by email: " + e.getMessage());
        }
        return results;
    }

    // Main method for testing the search functionality
    public static void main(String[] args) {
        SearchDatabase searchDatabase = new SearchDatabase();

        // Example usage: search by department name
        System.out.println("Search by Department: IT");
        List<String> departmentResults = searchDatabase.searchByDepartment("IT");
        departmentResults.forEach(System.out::println);

        // Example usage: search by role name
        System.out.println("\nSearch by Role: Engineer");
        List<String> roleResults = searchDatabase.searchByRole("Engineer");
        roleResults.forEach(System.out::println);

        // Example usage: search by person's name
        System.out.println("\nSearch by Name: Ashley");
        List<String> nameResults = searchDatabase.searchByName("Ashley");
        nameResults.forEach(System.out::println);

        // Example usage: search by ID number
        System.out.println("\nSearch by ID Number: 1234087");
        List<String> idResults = searchDatabase.searchByIdNumber("1234087");
        idResults.forEach(System.out::println);

        // Example usage: search by email
        System.out.println("\nSearch by Email: lindix332@gmail.com");
        List<String> emailResults = searchDatabase.searchByEmail("lindix332@gmail.com");
        emailResults.forEach(System.out::println);
    }
}
