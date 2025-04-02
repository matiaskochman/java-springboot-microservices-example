package com.ejemplo.productservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.productservice.model.Product;
import com.ejemplo.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final Environment env; // Declaramos la variable env

    @Autowired
    public ProductController(ProductService productService, Environment env) {
        this.productService = productService;
        this.env = env; // Inyectamos el Environment
    }

    @GetMapping
    public Map<String, Object> listProducts() {
        List<Product> products = productService.getAllProducts();
        // Obtenemos el puerto donde se ejecuta la aplicación
        String port = env.getProperty("local.server.port");

        Map<String, Object> response = new HashMap<>();
        response.put("port", port);
        response.put("products", products);
        return response;
    }
}
