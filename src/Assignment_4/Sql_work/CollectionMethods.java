package Assignment_4.Sql_work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CollectionMethods {

    public static void addCollection(String name, String ownerName) {
        String query = "INSERT INTO collection (name, owner_name) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, ownerName);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "Collection added successfully." : "Failed to add collection.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in addCollection(): " + e.getMessage());
        }
    }

    public static void deleteCollection(int id) {
        String query = "DELETE FROM collection WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println(rowsAffected > 0 ? "Collection deleted successfully." : "No collection found with ID: " + id);

        } catch (SQLException e) {
            System.err.println("SQL Exception in deleteCollection(): " + e.getMessage());
        }
    }

    public static void updateCollection(int id, String name, String ownerName) {
        String query = "UPDATE collection SET name = ?, owner_name = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, ownerName);
            pstmt.setInt(3, id);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "Collection updated successfully." : "Update failed, collection not found.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in updateCollection(): " + e.getMessage());
        }
    }
}
