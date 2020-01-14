import implementation.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {


    @Test
    void triangle_nonExistentSetOfLengths_Exception(){

        //  Arrange
        double[] lengths = new double[] {1, 1, 3};
        //  Assert                                      //  Act
        Assertions.assertThrows(Exception.class, () -> new Triangle(lengths));
    }

    /*
    *   A degenerate triangle is a triangle that is a segment of a line, i.e. where the triangle inequality actually
    *   leads to an equality
    **/
    @Test
    void triangle_degenerateTriangle_Exception(){

        //  Arrange
        double[] lengths = new double[] {1, 2, 3};
        //  Assert                                      //  Act
        Assertions.assertThrows(Exception.class, () -> new Triangle(lengths));
    }

    @Test
    void triangle_acceptableSetOfLengths_Triangle() throws Exception{

        //  Arrange
        double[] lengths = new double[] {2, 3, 4};
        // Act
        Triangle actual = new Triangle(lengths);
    }

    @Test
    void triangle_irregularSetOfLengths_String() throws Exception{

        //  Arrange
        double[] lengths = new double[] {2, 3, 4};
        // Act
        Triangle triangle = new Triangle(lengths);

        Assertions.assertEquals("This triangle is Irregular: It has 3 different sides", triangle.type());
    }

    @Test
    void triangle_isoscelesSetOfLengths_String() throws Exception{

        //  Arrange
        double[] lengths = new double[] {3, 3, 4};
        // Act
        Triangle triangle = new Triangle(lengths);

        Assertions.assertEquals("This triangle is isosceles: It has 2 equals sides.", triangle.type());
    }

    @Test
    void triangle_equilateralSetOfLengths_String() throws Exception{

        //  Arrange
        double[] lengths = new double[] {6, 6, 6};
        // Act
        Triangle triangle = new Triangle(lengths);

        Assertions.assertEquals("This triangle is Equilateral: All its sides have the same length.",
                triangle.type());
    }


}
