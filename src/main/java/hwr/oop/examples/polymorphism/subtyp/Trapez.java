package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

class Trapez implements Quadrangle{

    private final double height;
    private final double sideA, sideB, sideC, sideD;

    public Trapez(double height, double sideA, double sideB, double sideC, double sideD) {
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(Math.asin(height/sideD)); //alpha
        angles.add(Math.asin(height/sideB)); //beta
        angles.add(180-angles.get(1));       //gamma
        angles.add(180-angles.get(0));       //delta
        return angles;
    }

    @Override
    public double getPerimeterLength() {
        return sideA+sideB+sideC+sideD;
    }

    @Override
    public double getAreaSize() {
        return ((sideA+sideC)/2)*height;
    }
}
