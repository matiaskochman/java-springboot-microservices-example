  package com.ejemplo.productservice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType; // Para Hamcrest matchers como hasSize, is
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // Carga el contexto completo de la aplicación
@AutoConfigureMockMvc // Configura MockMvc para hacer peticiones HTTP simuladas
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc; // Inyecta MockMvc

    @Test
    void listProducts_shouldReturnProductList() throws Exception {
        mockMvc.perform(get("/products")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Verifica que la propiedad "products" contenga 3 elementos
                .andExpect(jsonPath("$.products", hasSize(3)))
                // Verifica los datos de los productos dentro de la propiedad "products"
                .andExpect(jsonPath("$.products[0].id", is(1)))
                .andExpect(jsonPath("$.products[0].name", is("Laptop Pro")))
                .andExpect(jsonPath("$.products[1].id", is(2)))
                .andExpect(jsonPath("$.products[2].id", is(3)));
    }


    // Podrías añadir más tests para otros endpoints si los tuvieras
}