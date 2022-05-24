package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

public class IsoscelesTriangle implements Dreieck {

    private double sideA, sideB;

    public IsoscelesTriangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }


    @Override
    public ArrayList<Double> getDistinctAngles() {
        return null;
    }

    @Override
    public double getPerimeterLength() {
        return sideA*2+sideB;
    }

    @Override
    public double getAreaSize() {
        return 0.5*sideB*calculateHeight();
    }

    double calculateHeight(){
        return 0.5 * Math.sqrt(4* Math.pow(sideA-sideB,2));
    }
}
