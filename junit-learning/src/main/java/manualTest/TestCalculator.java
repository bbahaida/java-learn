package manualTest;

import calculatorApp.Calculator;

public class TestCalculator {
    private int nbErrors = 0;
    public static void main(String[] args) {

        TestCalculator testCalculator = new TestCalculator();

        /*
        try {
            testCalculator.addTest();
        }catch (Throwable e){
            testCalculator.nbErrors++;
            e.printStackTrace();
        }

        if (testCalculator.nbErrors>0){
            throw new RuntimeException("There were "+testCalculator.nbErrors+" error(s)" );
        }*/

        System.out.print(testCalculator.pyramid(5));

    }

    public String triangle(int rows){
        String result = "";
        for (int i = 0; i < rows ; i++){
            for (int j = 0; j < i; j++){
                result+="*";
            }
            if(i>0 && i<rows-1)
                result+="\n";
        }
        return result;
    }

    /*

    expected :
    *
   ***
  *****
 *******
*********
     */
    public String pyramid(int rows){
        String result = "";
        int spaces;
        for (int i = 0; i < rows ; i++){
            spaces = rows - i;
            for (int k = 0; k < spaces-1; k++)
                result+=" ";
            for (int j = 0; j < ((i*2)+1); j++){
                result+="*";
            }
            if(i<rows-1)
                result+="\n";
        }
        return result;
    }

    private void addTest()throws RuntimeException{
        Calculator calculator = new Calculator();
        double result = calculator.add(10,50);
        if (result != 60){
            throw new RuntimeException("Bad result: "+result);
        }else {
            System.out.println("Test passed");
        }
    }
}
