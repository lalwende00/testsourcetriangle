import implementation.InputParserRegex;
import implementation.Triangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  There are 3 public methods used in this application
 *
 *  A method to parse an input with a specific format:
 *      *   double[] implementation.InputParser.parseInput(String input) throws Exception
 *
 *  A implementation.Triangle constructor implementation.Triangle(double[] lengths)
 *
 *
 *  A method that gives the type of the triangle:
 *      *   String TriangleInstance.type()
 *
 *  Those methods are tested individually (unit tests) and as a whole (integration test) in the test folder.
 **/
public class Main {

    public static void main(String[] args) {

        String input;

        String prompt =
                "Enter triangle lengths with format (a,b,c) or (a, b, c) to evaluate if it's a triangle" +
                " and the nature of this triangle.\nEnter x to leave.";

        while(!(input = input(prompt)).equals("x")){

            try{
                // Parsing an input with a specific format: success or exception thrown
                //double[] splitInput = implementation.InputParser.parseInput(input);
                double[] parsedInput = InputParserRegex.parseInput(input);

                // Creating a triangle with the parsed above lengths: success or exception thrown
                Triangle triangle = new Triangle(parsedInput);

                // Displaying in the console the resulting nature of the triangle: success
                System.out.println(triangle.type());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     *  I/O method to get an input from the user
     * */
    private static String input(String prompt){
        System.out.println(prompt);
        try{ return new BufferedReader(new InputStreamReader(System.in)).readLine(); }
        catch (Exception e){
            System.out.println("An error occured");
            return input(prompt);
        }
    }
}
