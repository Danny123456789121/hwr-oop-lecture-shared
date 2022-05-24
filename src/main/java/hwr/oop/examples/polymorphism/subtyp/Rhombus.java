package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

class Rhombus extends Parallelogramm {

    private final double sideA;
    private final double angleAlpha;

    public Rhombus(double sideA, double angleAlpha) {
        super(sideA, sideA, angleAlpha);
        this.sideA = sideA;
        this.angleAlpha = Math.toDegrees(angleAlpha);
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(180-angleAlpha);     //alpha and gamma
        angles.add(180-angles.get(0));  //beta and delta
        return angles;
    }

    @Override
    public double getPerimeterLength() {
        return sideA*4;
    }

    @Override
    public double getAreaSize() {
        return Math.pow(sideA,2)*Math.sin(angleAlpha);
    }
}
