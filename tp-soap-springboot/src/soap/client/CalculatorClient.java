package soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import soap.model.CalculatorRequest;
import soap.model.CalculatorResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

    private static final String WSDL_URL = "http://localhost:8080/ws/calculator";

    public double add(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Add"));

        return response.getResult();
    }

    public double subtract(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Subtract"));

        return response.getResult();
    }

    public double multiply(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Multiply"));

        return response.getResult();
    }

    public double divide(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Divide"));

        return response.getResult();
    }

    public double modulo(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Modulo"));

        return response.getResult();
    }

    public double power(double a, double b) {
        CalculatorRequest request = new CalculatorRequest();
        request.setA(a);
        request.setB(b);

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URL, request,
                        new SoapActionCallback("Power"));

        return response.getResult();
    }

    public static void main(String[] args) {
        org.springframework.ws.client.core.WebServiceTemplate template =
                new org.springframework.ws.client.core.WebServiceTemplate();


        System.out.println("=== Test du client SOAP ===\n");

    }
}