package hwr.oop.examples.polymorphism.subtyp;

import java.util.ArrayList;

public interface Dreieck extends Shape, Comparable<Dreieck>{

    @Override
    default int getNumberOfSides() {return 3;}

    ArrayList<Double> getDistinctAngles();

    @Override
    default int compareTo(Dreieck o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
