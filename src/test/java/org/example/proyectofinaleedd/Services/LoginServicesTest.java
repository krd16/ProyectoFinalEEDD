package org.example.proyectofinaleedd.Services;

import org.example.proyectofinaleedd.Repositories.LoginRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginServicesTest {

    // ── Validation tests (no Mockito needed) ──────────────────────────────────

    @Test
    void login_emptyUsername_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> LoginServices.login("", "1234"));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void login_emptyPassword_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> LoginServices.login("admin", ""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void login_bothFieldsEmpty_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> LoginServices.login("", ""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void login_whitespaceOnly_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> LoginServices.login("   ", "   "));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    // ── Mockito tests ─────────────────────────────────────────────────────────

    @Test
    void login_validCredentials_callsRepository() throws Exception {
        try (MockedStatic<LoginRepository> mockRepo = mockStatic(LoginRepository.class)) {
            assertDoesNotThrow(() -> LoginServices.login("admin", "1234"));

            mockRepo.verify(() -> LoginRepository.login("admin", "1234"), times(1));
        }
    }

    @Test
    void login_wrongCredentials_propagatesRepositoryException() {
        try (MockedStatic<LoginRepository> mockRepo = mockStatic(LoginRepository.class)) {

            mockRepo.when(() -> LoginRepository.login(anyString(), anyString()))
                    .thenThrow(new Exception("Error: Usuario o contraseña incorrectos."));

            Exception ex = assertThrows(Exception.class,
                    () -> LoginServices.login("admin", "wrongpass"));

            assertTrue(ex.getMessage().contains("Usuario o contraseña incorrectos."));
        }
    }
}