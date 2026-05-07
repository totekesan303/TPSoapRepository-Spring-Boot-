package soap.temperature;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TemperatureEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/temperature";

    public TemperatureResponse celsiusToFahrenheit(TemperatureRequest request) {
        TemperatureResponse response = new TemperatureResponse();
        double celsius = request.getValue();
        double fahrenheit = celsius * 9.0/5.0 + 32;
        response.setResult(fahrenheit);
        response.setUnit("°F");
        System.out.printf("Conversion: %.2f°C = %.2f°F%n", celsius, fahrenheit);
        return response;
    }


    public TemperatureResponse fahrenheitToCelsius(TemperatureRequest request) {
        TemperatureResponse response = new TemperatureResponse();
        double fahrenheit = request.getValue();
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        response.setResult(celsius);
        response.setUnit("°C");
        System.out.printf("Conversion: %.2f°F = %.2f°C%n", fahrenheit, celsius);
        return response;
    }


    public TemperatureResponse celsiusToKelvin(TemperatureRequest request) {
        TemperatureResponse response = new TemperatureResponse();
        double celsius = request.getValue();
        double kelvin = celsius + 273.15;
        response.setResult(kelvin);
        response.setUnit("K");
        System.out.printf("Conversion: %.2f°C = %.2fK%n", celsius, kelvin);
        return response;
    }
}