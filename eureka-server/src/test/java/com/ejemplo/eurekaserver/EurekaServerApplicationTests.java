package com.ejemplo.eurekaserver;

// Imports necesarios (Asegúrate de que estos paquetes existan en tu classpath vía Maven)
import org.junit.jupiter.api.Test; // Import para @Test
import org.springframework.boot.test.context.SpringBootTest; // Import para @SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment; // Import para WebEnvironment

// --- INICIO DE LA DEFINICIÓN DE LA CLASE ---
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, // Anotación de Spring Boot Test
                properties = { // Propiedades para configurar el test
                    "eureka.client.register-with-eureka=false",
                    "eureka.client.fetch-registry=false"
                })
class EurekaServerApplicationTests { // <--- Nombre de la clase

    // --- INICIO DEL MÉTODO DE PRUEBA ---
    @Test // Anotación de JUnit para marcar esto como un método de prueba
    void contextLoads() { // <--- Nombre del método
        // Este método está vacío a propósito.
        // Su objetivo es simplemente verificar si el contexto de la aplicación
        // Spring Boot puede cargarse sin lanzar excepciones.
        // Si la prueba pasa, significa que la configuración básica es correcta.
        System.out.println("Eureka Server context loaded successfully!");
    } // --- FIN DEL MÉTODO DE PRUEBA ---

} // --- FIN DE LA DEFINICIÓN DE LA CLASE ---