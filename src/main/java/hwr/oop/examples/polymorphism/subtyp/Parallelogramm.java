package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

class Parallelogramm implements Quadrangle{

    private final double sideA, sideB, angleAlpha;

    public Parallelogramm(double sideA, double sideB, double angleAlpha) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleAlpha = angleAlpha;
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(angleAlpha); //alpha and gamma
        angles.add(180-angleAlpha); //beta and delta

        return new ArrayList<>();
    }

    @Override
    public double getPerimeterLength() {
        return 2*(sideA+sideB);
    }

    @Override
    public double getAreaSize() {
        double minSide = Math.min(sideA, sideB);
        double maxSide = Math.max(sideA, sideB);
        return Math.sqrt(Math.pow(maxSide,2)-Math.pow(minSide,2)*minSide);
    }
}
