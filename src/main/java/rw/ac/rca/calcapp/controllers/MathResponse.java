package rw.ac.rca.calcapp.controllers;

public class MathResponse {
    private double calcResponse;

    public MathResponse(double calcResponse) {
        this.calcResponse = calcResponse;
    }

    public double getCalcResponse() {
        return calcResponse;
    }
}