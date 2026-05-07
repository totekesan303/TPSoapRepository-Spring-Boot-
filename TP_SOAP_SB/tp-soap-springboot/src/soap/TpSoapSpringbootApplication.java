package soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSoapSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TpSoapSpringbootApplication.class, args);
        System.out.println("Serveur SOAP démarré sur http://localhost:8080");
        System.out.println("WSDL disponible sur http://localhost:8080/ws/calculator?wsdl");
    }
}