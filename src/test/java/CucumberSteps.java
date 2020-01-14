import cucumber.api.java8.En;
import implementation.InputParser;
import implementation.Triangle;
import org.junit.Assert;

public class CucumberSteps implements En {

    private String input;
    private String response;

    public CucumberSteps() {

        Given("^I Write the length \"([^\"]*)\"$", (String input) -> this.input = input);

        /*
         *  This is where the operations are applied to the input.
         *  Effectively, this is the reason why we talk about "integration test"
         *  We test in the same operation methods from two different components.
         *
         *  We have to get a response at this stage.
         * This response has to be a message the user can read, i.e. a String.
         **/
        When("^I press Enter$", () -> {
            try{
                /*
                 *  Even though the implementation.InputParserRegex provides a method that cannot lead to any format
                 * error, The method doesn't meet all of the customer requirements.
                 *  This illustrates the contrast between integration testing and unit testing.
                 **/
                //double[] parsedLengths = implementation.InputParserRegex.parseInput(input);
                double[] parsedLengths = InputParser.parseInput(input);
                Triangle triangle = new Triangle(parsedLengths);
                this.response = triangle.type();
            }
            catch (Exception e){ this.response = e.getMessage(); }
        });

        Then("^I should be told \"([^\"]*)\"$",
                (String expectedResponse) -> Assert.assertEquals(expectedResponse, this.response));






        // Useless artifact as to not be bothered by the feature file
//        Given("^I Write the length <lengths>$", () -> {
//        });
    }
}
