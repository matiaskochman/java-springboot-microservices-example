package com.ejemplo.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getters, Setters, toString, equals, hashCode (de Lombok)
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
}