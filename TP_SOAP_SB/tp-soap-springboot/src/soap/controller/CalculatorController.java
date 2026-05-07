package soap.controller;

import com.example.soap.client.CalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorClient calculatorClient;

    @GetMapping("/add/{a}/{b}")
    public Map<String, Object> add(@PathVariable double a, @PathVariable double b) {
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "add");
        result.put("a", a);
        result.put("b", b);
        result.put("result", calculatorClient.add(a, b));
        return result;
    }

    @GetMapping("/subtract/{a}/{b}")
    public Map<String, Object> subtract(@PathVariable double a, @PathVariable double b) {
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "subtract");
        result.put("a", a);
        result.put("b", b);
        result.put("result", calculatorClient.subtract(a, b));
        return result;
    }

    @GetMapping("/multiply/{a}/{b}")
    public Map<String, Object> multiply(@PathVariable double a, @PathVariable double b) {
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "multiply");
        result.put("a", a);
        result.put("b", b);
        result.put("result", calculatorClient.multiply(a, b));
        return result;
    }

    @GetMapping("/divide/{a}/{b}")
    public Map<String, Object> divide(@PathVariable double a, @PathVariable double b) {
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "divide");
        result.put("a", a);
        result.put("b", b);
        try {
            result.put("result", calculatorClient.divide(a, b));
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }
        return result;
    }
}