package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

public interface Quadrangle extends Shape, Comparable<Quadrangle> {
    @Override
    default int getNumberOfSides() { return 4; }

    ArrayList<Double> getDistinctAngles();

    @Override
    default int compareTo(Quadrangle o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
