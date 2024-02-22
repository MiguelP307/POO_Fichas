import static java.lang.System.in;
import static java.lang.System.out;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;


public class Ex4 {
    
    public static void main(String[] args){

        boolean keepGoing = true;

        //Store the highest variation recorded
        double highestVariation = 0;
        double currentVariation;
        int[] days = new int[2];

        int currentDay = 2;

        // Used to get the variation;
        double currentTemp;
        double lastTemp;

        // Useful to determine the average temp
        double tempSum = 0;
        int numberOfTempInserted = 1;
        
        Scanner input = new Scanner(System.in);

        out.print("Insert a temperature: ");
        lastTemp = input.nextDouble();
        tempSum += lastTemp;

        while(keepGoing){

            out.print("Insert a temperature: ");
            currentTemp = input.nextDouble();
            
            if(currentTemp == 83847980)
                keepGoing = false;
            else {
                currentVariation = currentTemp - lastTemp;
                
                if(Math.abs(currentVariation) > Math.abs(highestVariation)){
                    highestVariation = currentVariation;
                    days[0] = currentDay - 1;
                    days[1] = currentDay;
                }

                tempSum += currentTemp;
                lastTemp = currentTemp;
                numberOfTempInserted++;
                currentDay++;
            }
            
        }

        out.printf("A media das %d temperaturas foi de %.1f graus\nA maior variacao registou-se entre os dias %d e %d, tendo a temperatura ", numberOfTempInserted, tempSum/numberOfTempInserted, days[0],days[1]);

        if(highestVariation > 0)
            out.print("subido ");
        else
            out.print("descido ");

        out.printf("%.1f graus.\n", Math.abs(highestVariation));
        

    }    
}
