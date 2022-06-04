package hwr.oop.examples.polymorphism.subtyp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapesTest {

    @Nested
    class SquareTest {
        @Test
        void square_IsPolymorphicType() {
            Shape square = new Square(42);
            assertThat(square)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class)
                    .isInstanceOf(Square.class);
        }

        @Test
        void squareIsRectangle_ButRectangleIsNoSquare() {
            Shape square = new Square(42);
            Shape rectangle = new Rectangle(13, 37);
            assertThat(square).isInstanceOf(Rectangle.class);
            assertThat(rectangle).isNotInstanceOf(Square.class);
        }

        @Test
        void square_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape square = new Square(42);
            double perimeterLength = square.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(4 * 42);
        }

        @Test
        void square_GetAreaSize_IsSideLengthSquared() {
            Shape square = new Square(42);
            double areaSize = square.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 42);
        }

        @Test
        void square_GetNumberOfSides_ReturnsFour() {
            Shape square = new Square(42);
            int numberOfSides = square.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }
    }

    @Nested
    class RectangleTest {
        @Test
        void rectangle_IsPolymorphicType() {
            Rectangle rectangle = new Rectangle(42, 1337);
            assertThat(rectangle)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class);
        }

        @Test
        void rectangle_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape rectangle = new Rectangle(42, 1337);
            double perimeterLength = rectangle.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42 + 42 + 1337 + 1337);
        }

        @Test
        void rectangle_GetAreaSize_IsSideLengthSquared() {
            Shape rectangle = new Rectangle(1337, 42);
            double areaSize = rectangle.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 1337);
        }

        @Test
        void rectangle_GetNumberOfSides_ReturnsFour() {
            Shape rectangle = new Rectangle(42, 1337);
            int numberOfSides = rectangle.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Quadrangle> first = new Rectangle(1, 2);
            Comparable<Quadrangle> second = new Rectangle(1, 2);

        }
    }

    @Nested
    class RhombusTest {

        private Shape rhombus;
        @BeforeEach
        void setUp(){rhombus = new Rhombus(42, 69);}


        @Test
        void rhombus_IsPolymorphicType() {
            assertThat(rhombus)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Parallelogramm.class)
                    .isInstanceOf(Rhombus.class);
        }

        @Test
        void rhombus_GetPerimeterLength_IsFourTimesProvidedSize() {
            double perimeterLength = rhombus.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42 + 42 + 42 + 42);
        }

        @Test
        void rhombus_GetAreaSize_IsSideSquaredTimesSinOfAlpha() {
            double areaSize = rhombus.getAreaSize();
            assertThat(areaSize).isEqualTo(42*42*Math.sin(Math.toDegrees(69)));
        }

        @Test
        void rhombus_GetNumberOfSides_ReturnsFour() {
            int numberOfSides = rhombus.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

    }

    @Nested
    class ParallelogrammTest {

        private Shape parallelogramm;
        @BeforeEach
        void setUp(){parallelogramm = new Parallelogramm(42, 21, 80);        }

        @Test
        void parallelogramm_IsPolymorphicType() {
            assertThat(parallelogramm)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Parallelogramm.class);
        }

        @Test
        void parallelogramm_GetPerimeterLength_BothSidesAddedTimes2() {
            double perimeterLength = parallelogramm.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo((42+21)*2);
        }

        @Test
        void parallelogramm_GetAreaSize_IsSqrtOfLongerSideSquaredMinusSmallerSideSquaredTimesSmallerSide() {
            double areaSize = parallelogramm.getAreaSize();
            assertThat(areaSize).isEqualTo(Math.sqrt(Math.pow(42,2)-Math.pow(21,2))*21);
        }

        @Test
        void parallelogramm_GetNumberOfSides_ReturnsFour() {
            int numberOfSides = parallelogramm.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

    }

    @Nested
    class TrapezTest {


        private Shape trapez;
        @BeforeEach
        void setUp(){
            try {
                trapez = new Trapez(10,8,3,9);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        void trapez_IsPolymorphicType() {
            assertThat(trapez)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Trapez.class);
        }

        @Test
        void trapez_GetPerimeterLength_BothSidesAddedTimes2() {
            double perimeterLength = trapez.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(10.4403065089105502+12.8062484748656974+8+3+9*2);
            //assertThat((double)Math.round(perimeterLength*1000)/1000).isEqualTo(52.247);
        }

        @Test
        void trapez_GetAreaSize_IsSideAPlusSideCDividedBy2TimesHeight() {
            double areaSize = trapez.getAreaSize();
            assertThat(areaSize).isEqualTo(145);
        }

        @Test
        void trapez_GetNumberOfSides_ReturnsFour() {
            int numberOfSides = trapez.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        /*
        @Test
        void trapez_checkIfProvidedValuesIsATrapezoid(){
            System.out.println(trapez.getAreaSize());
            assertThrows(Exception.class, () -> new Trapez(10.1,4.5,5,5));

        }
         */
    }

    @Nested
    class IsoscelesTriangleTest {

        private Shape gleichschenkligesDreieck;
        @BeforeEach
        void setUp(){gleichschenkligesDreieck = new IsoscelesTriangle(34.4,30);
        }

        @Test
        void isoscelesTriangle_IsPolymorphicType() {
            assertThat(gleichschenkligesDreieck)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Triangle.class)
                    .isInstanceOf(IsoscelesTriangle.class);
        }

        @Test
        void isoscelesTriangle_GetPerimeterLength_IsOneSideTimesTwoPlusTheOtherSide() {
            double perimeterLength = gleichschenkligesDreieck.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(34.4*2+30);
        }

        @Test
        void isoscelesTriangle_GetAreaSize_IsSideBTimesHeightTimesAHalf() {
            double areaSize = gleichschenkligesDreieck.getAreaSize();
            assertThat(areaSize).isEqualTo((0.5*30)*0.5 * Math.sqrt(4* Math.pow(34.4-30,2)));
        }

        @Test
        void isoscelesTriangle_GetNumberOfSides_ReturnsThree() {
            int numberOfSides = gleichschenkligesDreieck.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(3);
        }
    }

}
