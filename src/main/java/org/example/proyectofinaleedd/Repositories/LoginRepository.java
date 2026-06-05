package org.example.proyectofinaleedd.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {
    public static void login(String username, String password) throws Exception {
        try (
                PreparedStatement statement = DBConnection.getConnection().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?")
        ) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new Exception("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
