package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

public class RightTriangle implements Triangle{

    private final double sideA;
    private final double sideB;
    private final double hypotenuse;

    public RightTriangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.hypotenuse = Math.sqrt(Math.pow(sideA,2)+Math.pow(sideB,2));
    }

    @Override
    public double getPerimeterLength() {
        return sideA+sideB+hypotenuse;
    }

    @Override
    public double getAreaSize() {
        return (sideA*sideB)/2;
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(90d);
        angles.add(Math.asin(sideA/hypotenuse));
        angles.add(Math.asin(sideB/hypotenuse));
        return angles;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }
}
