import implementation.InputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *  Testing
 **/
public class InputParserTest {



    //  ----------------------------------------    double[]     ---------------------------------------    //

    @Test
    void parseInput_noSpaces_doubleArray() throws Exception {
        //  Arrange
        String input = "(1,2,3)";

        //  Act
        double[] actual = InputParser.parseInput(input);

        //  Assert
        Assertions.assertArrayEquals( new double[] {1, 2, 3}, actual);
    }

    @Test
    void parseInput_spaces_doubleArray() throws Exception {
        //  Arrange
        String input = "(1, 2, 3)";

        //  Act
        double[] actual = InputParser.parseInput(input);

        //  Assert
        Assertions.assertArrayEquals( new double[] {1, 2, 3}, actual);
    }


    //  -----------------------------------------    Exceptions  ----------------------------------------    //

    @Test
    void parseInput_noParenthesis_Exception(){
        String input = "1, 2, 3";

        Assertions.assertThrows(Exception.class, () -> {
           InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_noParenthesisLeft_Exception(){
        String input = "1, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_noParenthesisRight_Exception(){
        String input = "(1, 2, 3";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_moreThanThreeElements_Exception(){
        String input = "(1, 2, 3, 4)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_lessThanThreeElements_Exception(){
        String input = "(1, 2)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_nonNumericA_Exception(){
        String input = "(a, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_nonNumericB_Exception(){
        String input = "(1, b, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_nonNumericC_Exception(){
        String input = "(1, 2, c)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_negativeA_Exception(){
        String input = "(-1, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_negativeB_Exception(){
        String input = "(1, -2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_negativeC_Exception(){
        String input = "(1, 2, -3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_superiorA_Exception(){
        String input = "(9.0001, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_superiorB_Exception(){
        String input = "(1, 9.0001, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_superiorC_Exception(){
        String input = "(1, 2, 9.0001)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_zeroA_Exception(){
        String input = "(0, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_zeroB_Exception(){
        String input = "(1, 0, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_zeroC_Exception(){
        String input = "(1, 2, 0)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_spaceBeforeA_Exception(){
        String input = "( 1, 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_spaceAfterA_Exception(){
        String input = "(1 , 2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_twoSpacesBeforeB_Exception(){
        String input = "(1,  2, 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_spaceAfterB_Exception(){
        String input = "(1, 2 , 3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_twoSpacesBeforeC_Exception(){
        String input = "(1, 2,  3)";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    void parseInput_spaceAfterC_Exception(){
        String input = "(1, 2, 3 )";

        Assertions.assertThrows(Exception.class, () -> {
            InputParser.parseInput(input);
        });
    }
























    /*
     *  Testing that the number entered by the user is:
     *      *   a number
     *      *   between 0 and 9
     * */
    private static double checkNumber(String numberCandidate) throws Exception{
        try{
            // If the candidate is not a number, an exception will be thrown here
            double numberToTest = Double.parseDouble(numberCandidate);
            if(numberToTest >= 0 && numberToTest <= 9) return numberToTest;
            else throw new Exception("a b and c have to be between 0 and 9");
        } catch (NumberFormatException e){ throw new Exception("a b and c have to be numbers"); }
    }

    @Test()
    void checkNumber_inferior_Exception(){

        // Arrange : partie initialization
        String numberToParse = "-1";
        // Act : partie qui appelle le code

        // Assert : partie qui verifie que le resultat est celui attendu
        Assertions.assertThrows(Exception.class, () -> {
            checkNumber(numberToParse);
        });
    }

    @Test()
    void checkNumber_superior_Exception(){

        // Arrange : partie initialization
        String numberToParse = "9.1";
        // Act : partie qui appelle le code

        // Assert : partie qui verifie que le resultat est celui attendu
        Assertions.assertThrows(Exception.class, () -> {
            checkNumber(numberToParse);
        });
    }

    @Test()
    void checkNumber_notNumeric_NumberFormatException(){

        // Arrange : partie initialization
        String numberToParse = "a";
        // Act : partie qui appelle le code

        // Assert : partie qui verifie que le resultat est celui attendu
        Assertions.assertThrows(Exception.class, () -> {
            checkNumber(numberToParse);
        });
    }
}
