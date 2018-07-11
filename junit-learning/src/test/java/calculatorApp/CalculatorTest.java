package calculatorApp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import manualTest.TestCalculator;

public class CalculatorTest extends TestCase {

    public CalculatorTest(String name) {
        super(name);
    }

    public void testAdd(){
        Calculator calculator = new Calculator();
        double result = calculator.add(10.02,50.2);
        assertEquals(60.2,result,0.1); // if actual >= expected-delta or actual <= expected+delta then the test will pass
    }

    public void testTriangle(){
        TestCalculator testCalculator = new TestCalculator();
        String expected = "*\n" +
                "**\n" +
                "***\n" +
                "****";
        String actaul = testCalculator.triangle(5);

        assertEquals(expected,actaul);
    }
    public void testPyramid(){
        TestCalculator testCalculator = new TestCalculator();
        String expected = "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********";
        String actaul = testCalculator.pyramid(5);

        assertEquals(expected,actaul);
    }
    /*
    public static Test suite(){
        TestSuite suite =  new TestSuite();
        suite.addTest(new CalculatorTest("testAdd"));

        return suite;
    }
    */
}