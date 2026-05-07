package soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.FaultDetail;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

import javax.xml.namespace.QName;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalculatorRequest")
    @ResponsePayload
    public CalculatorResponse handleRequest(@RequestPayload CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        return response;
    }


    public CalculatorResponse add(CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        double result = request.getA() + request.getB();
        response.setResult(result);
        System.out.printf("Addition: %.2f + %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return response;
    }

    public CalculatorResponse subtract(CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        double result = request.getA() - request.getB();
        response.setResult(result);
        System.out.printf("Soustraction: %.2f - %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return response;
    }

    public CalculatorResponse multiply(CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        double result = request.getA() * request.getB();
        response.setResult(result);
        System.out.printf("Multiplication: %.2f × %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return response;
    }

    public CalculatorResponse divide(CalculatorRequest request) {
        if (request.getB() == 0) {
            throw new DivisionByZeroException("Division par zéro impossible");
        }
        CalculatorResponse response = new CalculatorResponse();
        double result = request.getA() / request.getB();
        response.setResult(result);
        System.out.printf("Division: %.2f ÷ %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return response;
    }

    public CalculatorResponse modulo(CalculatorRequest request) {
        if (request.getB() == 0) {
            throw new DivisionByZeroException("Modulo par zéro impossible");
        }
        CalculatorResponse response = new CalculatorResponse();
        double result = request.getA() % request.getB();
        response.setResult(result);
        System.out.printf("Modulo: %.2f %% %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return result;
    }

    public CalculatorResponse power(CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        double result = Math.pow(request.getA(), request.getB());
        response.setResult(result);
        System.out.printf("Puissance: %.2f ^ %.2f = %.2f%n",
                request.getA(), request.getB(), result);
        return result;
    }

    @SoapFault(faultCode = SoapFault.FaultCode.CLIENT)
    public static class DivisionByZeroException extends RuntimeException {
        public DivisionByZeroException(String message) {
            super(message);
        }

        @FaultDetail
        public String getFaultDetail() {
            return "Impossible de diviser par zéro";
        }
    }
}