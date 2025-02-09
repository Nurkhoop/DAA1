package Assignment_4.Sql_work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class MediaMethods {

    public static void addMedia(String author, String genre, int year, int duration, int collectionId) {
        String query = "INSERT INTO musical_media (author, genre, year_of_manufacture, total_duration, collection_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, author);
            stmt.setString(2, genre);
            stmt.setInt(3, year);
            stmt.setInt(4, duration);
            stmt.setInt(5, collectionId);

            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Media successfully added." : "Failed to add media.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in addMedia(): " + e.getMessage());
        }
    }

    public static void deleteMedia(int mediaId) {
        String query = "DELETE FROM musical_media WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, mediaId);
            int rows = stmt.executeUpdate();

            System.out.println(rows > 0 ? "Media deleted successfully." : "No media found with ID: " + mediaId);

        } catch (SQLException e) {
            System.err.println("SQL Exception in deleteMedia(): " + e.getMessage());
        }
    }

    public static void updateMedia(int mediaId, String author, String genre, int year, int duration, int collectionId) {
        String query = "UPDATE musical_media SET author = ?, genre = ?, year_of_manufacture = ?, total_duration = ?, collection_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, author);
            stmt.setString(2, genre);
            stmt.setInt(3, year);
            stmt.setInt(4, duration);
            stmt.setInt(5, collectionId);
            stmt.setInt(6, mediaId);

            int result = stmt.executeUpdate();
            System.out.println(result > 0 ? "Media updated successfully." : "Update failed, media not found.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in updateMedia(): " + e.getMessage());
        }
    }

    public static void loadMedia(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        String query = "SELECT * FROM musical_media";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year_of_manufacture");
                int duration = rs.getInt("total_duration");
                int collectionId = rs.getInt("collection_id");

                tableModel.addRow(new Object[]{id, author, genre, year, duration, collectionId});
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception in loadMedia(): " + e.getMessage());
        }
    }
}