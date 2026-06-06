package org.example.proyectofinaleedd.Services;

import org.example.proyectofinaleedd.Repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockServicesTest {

    // ── getStock() ────────────────────────────────────────────────────────────

    @Test
    void getStock_emptyProduct_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.getStock(""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void getStock_whitespaceOnly_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.getStock("   "));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void getStock_validProduct_returnsStockFromRepository() throws Exception {
        try (MockedStatic<StockRepository> mockRepo = mockStatic(StockRepository.class)) {

            mockRepo.when(() -> StockRepository.getStock("Apple"))
                    .thenReturn(42);

            int result = StockServices.getStock("Apple");

            assertEquals(42, result);
            mockRepo.verify(() -> StockRepository.getStock("Apple"), times(1));
        }
    }

    @Test
    void getStock_productNotFound_propagatesRepositoryException() {
        try (MockedStatic<StockRepository> mockRepo = mockStatic(StockRepository.class)) {

            mockRepo.when(() -> StockRepository.getStock("Unknown"))
                    .thenThrow(new Exception("Error: Producto no encontrado."));

            Exception ex = assertThrows(Exception.class,
                    () -> StockServices.getStock("Unknown"));

            assertTrue(ex.getMessage().contains("Producto no encontrado."));
        }
    }

    // ── addProduct() ──────────────────────────────────────────────────────────

    @Test
    void addProduct_emptyName_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.addProduct("", "10"));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void addProduct_emptyStock_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.addProduct("Apple", ""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void addProduct_bothFieldsEmpty_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.addProduct("", ""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void addProduct_nonNumericStock_throwsNumberFormatException() {
        assertThrows(NumberFormatException.class,
                () -> StockServices.addProduct("Apple", "abc"));
    }

    @Test
    void addProduct_validData_callsRepository() throws Exception {
        try (MockedStatic<StockRepository> mockRepo = mockStatic(StockRepository.class)) {

            assertDoesNotThrow(() -> StockServices.addProduct("Apple", "10"));

            mockRepo.verify(() -> StockRepository.addProduct("Apple", 10), times(1));
        }
    }

    // ── removeProduct() ───────────────────────────────────────────────────────

    @Test
    void removeProduct_emptyName_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.removeProduct("", "5"));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void removeProduct_emptyAmount_throwsException() {
        Exception ex = assertThrows(Exception.class,
                () -> StockServices.removeProduct("Apple", ""));

        assertEquals("Todos los campos deben estar llenos.", ex.getMessage());
    }

    @Test
    void removeProduct_nonNumericAmount_throwsNumberFormatException() {
        assertThrows(NumberFormatException.class,
                () -> StockServices.removeProduct("Apple", "ten"));
    }

    @Test
    void removeProduct_validData_callsRepository() throws Exception {
        try (MockedStatic<StockRepository> mockRepo = mockStatic(StockRepository.class)) {

            assertDoesNotThrow(() -> StockServices.removeProduct("Apple", "3"));

            mockRepo.verify(() -> StockRepository.removeProduct("Apple", 3), times(1));
        }
    }

    @Test
    void removeProduct_insufficientStock_propagatesRepositoryException() {
        try (MockedStatic<StockRepository> mockRepo = mockStatic(StockRepository.class)) {

            mockRepo.when(() -> StockRepository.removeProduct("Apple", 100))
                    .thenThrow(new Exception("Error: No hay suficientes existencias de ese producto."));

            Exception ex = assertThrows(Exception.class,
                    () -> StockServices.removeProduct("Apple", "100"));

            assertTrue(ex.getMessage().contains("No hay suficientes existencias de ese producto."));
        }
    }
}