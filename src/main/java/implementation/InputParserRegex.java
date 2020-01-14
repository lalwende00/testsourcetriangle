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
 *  TODO: There is no way the method in this class can lead to incorrect formats.
 * */
public class InputParserRegex {

    public static double[] parseInput(String input) throws Exception{
        if(input.matches("\\(\\d(\\.\\d+)?, ?\\d(\\.\\d+)?, ?\\d(.\\d+)?\\)")){
            String[] resultString = input.substring(1, input.length()-1).split(",");
            return new double[] {
                    Double.parseDouble(resultString[0]),
                    Double.parseDouble(resultString[1]),
                    Double.parseDouble(resultString[2])
            };
        }
        else throw new Exception();
    }
}
