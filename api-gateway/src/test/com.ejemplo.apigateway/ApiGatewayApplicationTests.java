package com.ejemplo.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
                properties = {"eureka.client.enabled=false"}) // Desactiva Eureka para este test
//@ActiveProfiles("test") // Podrías tener un application-test.yml para desactivar Eureka
class ApiGatewayApplicationTests {

    @Test
    void contextLoads() {
        // Prueba simple que verifica si el contexto de Spring se carga sin errores
        // Si esto pasa, significa que la configuración básica es correcta.
        System.out.println("API Gateway context loaded successfully!");
    }

    // Pruebas más avanzadas podrían usar WebTestClient para verificar
    // el comportamiento del Gateway, pero requerirían mocks o servicios embebidos.
}