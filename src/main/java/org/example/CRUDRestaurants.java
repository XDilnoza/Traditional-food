package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDRestaurants {
    DBCinnection dbConnection = new DBCinnection();
    public void create(double latitude, double longitude,String info) {
        String sql = "insert into address(latitude, longitude,info)" +
                "values" + " ('" + latitude + "'," + "'" + longitude + "'," + "'" + info + "');";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int res = statement.executeUpdate();
            System.out.println(res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM address WHERE id = " + id;
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int res = statement.executeUpdate();
            System.out.println(res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProducts(int id, double newLatitude, double newLongitude,String newInfo) {
        String sql = "UPDATE address SET latitude = '" + newLatitude + "', longitude = '" + newLongitude + "', info = '" + newInfo + "' WHERE id = " + id;
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int res = statement.executeUpdate();
            System.out.println(res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
