package soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"result"})
@XmlRootElement(name = "CalculatorResponse", namespace = "http://example.com/calculator")
public class CalculatorResponse {

    @XmlElement(required = true)
    private double result;

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
}