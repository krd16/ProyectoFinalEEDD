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
            throw new Exception(e.getMessage());
        }
    }
}
