package org.example.proyectofinaleedd.Services;

import org.example.proyectofinaleedd.Repositories.StockRepository;

public class StockServices {
    public static int getStock(String product) throws Exception {
        if (product.isBlank()) {
            throw new Exception("Todos los campos deben estar llenos.");
        }

        return StockRepository.getStock(product);
    }

    public static void addProduct(String product, String stock) throws Exception {
        if (product.isBlank() || stock.isBlank()) {
            throw new Exception("Todos los campos deben estar llenos.");
        }

        StockRepository.addProduct(product, Integer.parseInt(stock));
    }
}
