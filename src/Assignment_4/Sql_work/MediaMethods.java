package Assignment_4.Sql_work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            if (rows > 0) {
                System.out.println("Media with ID " + mediaId + " has been deleted.");
            } else {
                System.out.println("No media found with ID: " + mediaId);
            }

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
}