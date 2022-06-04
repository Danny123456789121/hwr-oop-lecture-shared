package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

class Trapez implements Quadrangle{

    private final RightTriangle leftT, rightT;
    private final Rectangle rectangle;

    public Trapez(double height, double leftTLength, double rightTLength, double rectangleWidth) {
        this.leftT = new RightTriangle(height,leftTLength);
        this.rightT = new RightTriangle(height,rightTLength);
        this.rectangle = new Rectangle(height,rectangleWidth);

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
    }

    @Override
    public ArrayList<Double> getDistinctAngles() {
        ArrayList<Double> angles = new ArrayList<>();
        angles.add(leftT.getDistinctAngles().get(1)); //alpha
        angles.add(rightT.getDistinctAngles().get(1)); //beta
        angles.add(180-angles.get(1));       //gamma
        angles.add(180-angles.get(0));       //delta
        return angles;
    }

    @Override
    public double getPerimeterLength() {
        return leftT.getSideB()+rectangle.getWidth()+rightT.getSideB()+rightT.getHypotenuse()+rectangle.getWidth()+leftT.getHypotenuse();
    }

    @Override
    public double getAreaSize() {
        return leftT.getAreaSize()+rectangle.getAreaSize()+rightT.getAreaSize();
    }

}
