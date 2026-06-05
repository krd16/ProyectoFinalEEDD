package org.example.proyectofinaleedd.Services;

import org.example.proyectofinaleedd.Repositories.LoginRepository;

public class LoginServices {
    public static void login(String username, String password) throws Exception {
        if (username.isBlank() || password.isBlank()) {
            throw new Exception("Todos los campos deben estar llenos.");
        }

        LoginRepository.login(username, password);
    }
}
