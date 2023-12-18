package rw.ac.rca.calcapp.servicesImpl;
import rw.ac.rca.calcapp.services.MathOperator;

public class MathOperatorImpl implements MathOperator {

    @Override
    public double doMath(double operand1, double operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

