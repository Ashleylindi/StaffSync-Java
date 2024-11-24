package za.database_related;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseDatabase {

    // Method to add a department
    public static void addDepartment(String departmentName) {
        String query = "INSERT INTO departments (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, departmentName);
            stmt.executeUpdate();
            System.out.println("Department added: " + departmentName);
        } catch (SQLException e) {
            System.out.println("Error adding department: " + e.getMessage());
        }
    }

    // Method to add a role
    public static void addRole(String roleName) {
        String query = "INSERT INTO roles (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roleName);
            stmt.executeUpdate();
            System.out.println("Role added: " + roleName);
        } catch (SQLException e) {
            System.out.println("Error adding role: " + e.getMessage());
        }
    }

    // Method to add an employee
    public static void addEmployee(String firstName, String lastName, String email, String idNumber,
                                   String dateOfBirth, String gender, String citizenship, int age,
                                   int departmentId, int roleId) {
        String query = "INSERT INTO person (first_name, last_name, email, id_number, date_of_birth, " +
                "gender, citizenship, age, department_id, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, idNumber);
            stmt.setString(5, dateOfBirth);
            stmt.setString(6, gender);
            stmt.setString(7, citizenship);
            stmt.setInt(8, age);
            stmt.setInt(9, departmentId);
            stmt.setInt(10, roleId);
            stmt.executeUpdate();
            System.out.println("Employee added: " + firstName + " " + lastName);
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // Method to fetch all departments
    public static void getAllDepartments() {
        System.out.println("Please select the department assigned to the employee.");
        String query = "SELECT * FROM departments";
        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching departments: " + e.getMessage());
        }
    }

    // Method to fetch all roles
    public static void getAllRoles() {
        System.out.println("Please select the role assigned to the employee.");
        String query = "SELECT * FROM roles";
        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching roles: " + e.getMessage());
        }
    }

    // Method to fetch all employees
    public static void getAllEmployees() {
        String query = "SELECT * FROM person";
        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", First Name: " + rs.getString("first_name") +
                        ", Last Name: " + rs.getString("last_name") +
                        ", Email: " + rs.getString("email") +
                        ", Department ID: " + rs.getInt("department_id") +
                        ", Role ID: " + rs.getInt("role_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }
    }

    // Method to delete a department by ID
    public static void deleteDepartment(int departmentId) {
        String query = "DELETE FROM departments WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, departmentId);
            stmt.executeUpdate();
            System.out.println("Department with ID " + departmentId + " deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting department: " + e.getMessage());
        }
    }

    // Method to delete a role by ID
    public static void deleteRole(int roleId) {
        String query = "DELETE FROM roles WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, roleId);
            stmt.executeUpdate();
            System.out.println("Role with ID " + roleId + " deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting role: " + e.getMessage());
        }
    }

    // Method to delete an employee by ID
    public static void deleteEmployee(int employeeId) {
        System.out.println("Please select the employee to delete.");
        String query = "DELETE FROM person WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
            System.out.println("Employee with ID " + employeeId + " deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
