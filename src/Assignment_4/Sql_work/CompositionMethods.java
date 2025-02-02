package Assignment_4.Sql_work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompositionMethods {

    public static void addComposition(String name, int duration, int mediaId) {
        String query = "INSERT INTO musical_works (name, duration, media_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, duration);
            pstmt.setInt(3, mediaId);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "Composition added successfully." : "Failed to add composition.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in addComposition(): " + e.getMessage());
        }
    }

    public static void deleteComposition(int id) {
        String query = "DELETE FROM musical_works WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println(rowsAffected > 0 ? "Composition deleted successfully." : "No composition found with ID: " + id);

        } catch (SQLException e) {
            System.err.println("SQL Exception in deleteComposition(): " + e.getMessage());
        }
    }

    public static void updateComposition(int id, String name, int duration, int mediaId) {
        String query = "UPDATE musical_works SET name = ?, duration = ?, media_id = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, duration);
            pstmt.setInt(3, mediaId);
            pstmt.setInt(4, id);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "Composition updated successfully." : "Update failed, composition not found.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in updateComposition(): " + e.getMessage());
        }
    }
}