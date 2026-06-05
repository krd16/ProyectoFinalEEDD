package org.example.proyectofinaleedd.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockRepository {
    public static int getStock(String product) throws Exception {
        try (
                PreparedStatement statement = DBConnection.getConnection().prepareStatement("SELECT stock FROM productos WHERE nombre = ?");
        ) {
            statement.setString(1, product);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("stock");
            } else {
                throw new Exception("Producto no encontrado.");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public static void addProduct(String product, int stock) throws Exception {
        try (
                Connection connection = DBConnection.getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM productos WHERE nombre = ?");
            statement.setString(1, product);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareStatement("UPDATE productos SET stock = stock + ? WHERE nombre = ?");

                statement.setInt(1, stock);
                statement.setString(2, product);
            } else {
                statement = connection.prepareStatement("INSERT INTO productos VALUES (?, ?)");

                statement.setString(1, product);
                statement.setInt(2, stock);
            }

            statement.executeUpdate();

            statement.close();
            resultSet.close();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
