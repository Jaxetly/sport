package su.intercraft.repository;

import su.intercraft.model.InventoryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
    private final String url = "jdbc:postgresql://localhost:5432/sport";
    private final String user = "postgres";
    private final String password = "root";

    public List<InventoryItem> findAll() {
        List<InventoryItem> items = new ArrayList<>();
        String query = "SELECT * FROM inventory";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = (resultSet.getInt("id"));
                String name = resultSet.getString("name");
                String parameters = resultSet.getString("parameters");
                int age = resultSet.getInt("age");
                String placementConditions = resultSet.getString("placement_conditions");

                InventoryItem item = new InventoryItem(id, name, parameters, age, placementConditions);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public InventoryItem findById(int id) {
        InventoryItem item = null;
        String query = "SELECT * FROM inventory WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String parameters = resultSet.getString("parameters");
                int age = resultSet.getInt("age");
                String placementConditions = resultSet.getString("placement_conditions");

                item = new InventoryItem(id, name, parameters, age, placementConditions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}