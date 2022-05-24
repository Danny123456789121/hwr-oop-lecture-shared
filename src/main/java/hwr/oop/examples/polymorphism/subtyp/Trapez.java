package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

class Trapez implements Quadrangle{

    private final double height;
    private final double sideA, sideB, sideC, sideD;

    public Trapez(double sideA, double sideB, double sideC, double sideD) throws Exception {
        /*
        if(isTrapez()){
            this.height = calculateHeight();
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.sideD = sideD;
        }else
            throw new Exception("Not a Trapezoid");
*/
        this.height = calculateHeight();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(Math.asin(Math.toDegrees(height/sideD))); //alpha
        angles.add(Math.asin(Math.toDegrees(height/sideB))); //beta
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

    private boolean isTrapez(){
        return (getDistinctAngles().get(0) + getDistinctAngles().get(2) == 180) && getDistinctAngles().get(1) + getDistinctAngles().get(3) == 180;
    }

    private double calculateHeight(){
        return (2*getAreaSize())/(sideA+sideC);

    }
}
