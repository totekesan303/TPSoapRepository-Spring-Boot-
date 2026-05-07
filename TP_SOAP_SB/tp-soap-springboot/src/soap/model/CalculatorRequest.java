package soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"a", "b"})
@XmlRootElement(name = "CalculatorRequest", namespace = "http://example.com/calculator")
public class CalculatorRequest {

    @XmlElement(required = true)
    private double a;

    @XmlElement(required = true)
    private double b;

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }
}