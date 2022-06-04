package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

public interface Triangle extends Shape, Comparable<Triangle>{

    @Override
    default int getNumberOfSides() {return 3;}

    ArrayList<Double> getDistinctAngles();

    @Override
    default int compareTo(Triangle o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
