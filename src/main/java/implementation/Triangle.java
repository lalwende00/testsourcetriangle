package implementation;

/**
 *  This class, though named implementation.Triangle, focuses only on:
 *      Verifying that a triangle exists
 *      Determining the nature of the triangle:
 *          *   Irregular
 *          *   Isosceles
 *          *   Equilateral
 **/
public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double[] lengths) throws Exception{
        if(exists(lengths)){
            this.a = lengths[0];
            this.b = lengths[1];
            this.c = lengths[2];
        }
        else throw new Exception("This triangle does not exist");
    }

    /**
     *  The implementation.Triangle inequality states that the sum of the lengths of any two side of a triangle
     *  must be greater than (or equal) to the length of the third side.
     **/
    private static boolean exists(double[] lengths){
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) if(i != j) sum+= lengths[j];
            if(lengths[i] >= sum) return false;
        }
        return true;
    }

    public String type(){
        if(a == b && a == c) return "This triangle is Equilateral: All its sides have the same length.";
        else if(a == b || a ==c || b == c) return "This triangle is isosceles: It has 2 equals sides.";
        else return "This triangle is Irregular: It has 3 different sides";
    }
}
