package implementation;

/**
 *  Class encapsulating all operations necessary to clean a console input with a very specific format
 *  and to parse that input into 3 positive number with a maximal value of 9.
 *
 *      Target format:
 *          (a,b,c) or (a, b, c)
 *
 *      where a, b and c are >=0 and <= 9 (a,b and c must be numbers).
 *
 * */
public class InputParser {

    private InputParser(){}

    /*
     *  Method taking any IO console input, checking if that input has the right format and parses that input
     *  into 3 numbers returned into an array.
     *  All the specifications of the class are specified.
     * */
    public static double[] parseInput(String input) throws Exception{
        //  We begin by removing any white spaces that could be entered before and after the coordinates.
        //  Then, we use the "," String to split the input.
        String[] splitInput = input.trim().split(",");
        double[] cleanInput = new double[3];
        // Test1:
        // We should have 3 resulting String, or the format isn't correct.
        Exception e = new Exception("A triangle has three sides, " +
                "please enter lengths with format (a,b,c) or (a, b, c)");
        if(splitInput.length != 3) throw e;
        else{
            // TODO:    Uncomment this line to pass every integration test.
            //cleanInput[0] = checkA(splitInput[0]);
            // TODO:    Comment this line to pass every integration test.
            cleanInput[0] = incorrectCheckA(splitInput[0]);
            cleanInput[1] = checkB(splitInput[1]);
            cleanInput[2] = checkC(splitInput[2]);
        }
        return cleanInput;
    }

    /*
     *  Test2:
     *      The first element should be "(a", where a is a number between 0 and 9 both included
     *      TODO:   This method meets the requirements.
     * */
    private static double checkA(String a) throws Exception{
        Exception e = new Exception("Invalid format, please enter lengths with format (a,b,c) or (a, b, c)");

        if(a.charAt(0) != '(' || a.length() != a.trim().length()) throw e;
        else {
            String parenthesisRemovedA = a.substring(1);
            if(parenthesisRemovedA.length() != parenthesisRemovedA.trim().length()) throw e;
            else return checkNumber(a.substring(1));
        }
    }

    /*
     *  Test2:
     *      The first element should be "(a", where a is a number between 0 and 9 both included
     *      TODO:   This method doesn't meet the requirements.
     * */
    private static double incorrectCheckA(String a) throws Exception{
        if(a.length() != a.trim().length() || a.charAt(0) != '(')
            throw new Exception("Invalid format, please enter lengths with format (a,b,c) or (a, b, c)");
        else return checkNumber(a.substring(1));
    }

    /*
     *  Test3:
     *      The second element should be "b" or " b", where a is a number between 0 and 9 both included
     **/
    private static double checkB(String b) throws Exception{
        Exception e = new Exception("Invalid format, please enter lengths with format (a,b,c) or (a, b, c)");
        // get a version of b without any " " in it.
        String trimmedB = b.trim();

        if(b.length() == trimmedB.length()) return checkNumber(b);
        else {
            if(b.length() - 1 == trimmedB.length()){
                if(b.charAt(0) != ' ') throw e;
                else return checkNumber(trimmedB);
            }
            else throw e;
        }
    }

    /*
     *  Test4:
     *      The third element should be "c)" or " c)"
     *      First, we need to check that the parenthesis is the last character.
     **/
    private static double checkC(String c) throws Exception{
        Exception e = new Exception("Invalid format, please enter lengths with format (a,b,c) or (a, b, c)");
        String cleanC;
        int lastIndex = c.length() - 1;
        if(c.charAt(lastIndex) != ')') throw e;
        else cleanC = c.substring(0, lastIndex);
        // At this point, we must have "c" or " c"
        // The test is therefore the exact same test as test3.
        return checkB(cleanC);
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
            if(numberToTest > 0 && numberToTest <= 9) return numberToTest;
            else throw new Exception("a b and c have to be between 0 and 9");
        } catch (NumberFormatException e){ throw new Exception("a b and c have to be numbers"); }
    }

}
