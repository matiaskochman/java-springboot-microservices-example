package com.ejemplo.productservice.service;

import com.ejemplo.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    // Datos hardcodeados en lugar de una base de datos
    private static final List<Product> products = Arrays.asList(
            new Product(1L, "Laptop Pro", "Potente laptop para profesionales", 1200.50),
            new Product(2L, "Teclado Mecánico", "Teclado RGB con switches azules", 75.99),
            new Product(3L, "Monitor Curvo", "Monitor de 27 pulgadas QHD", 350.00)
    );

    public List<Product> getAllProducts() {
        System.out.println("Devolviendo lista de productos desde ProductService");
        return products;
    }

    // Podrías añadir métodos para obtener un producto por ID, etc.
    // public Product getProductById(Long id) { ... }
}