import static java.lang.System.out;

import java.util.Scanner;

public class Ex5 {
    
    public static void main(String[] args){

        float base;
        float height;

        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);

        while(keepGoing){
            out.print("Insert a base of a triangle: ");
            base = input.nextFloat();

            if(base == 0.0){
                out.println("\n\n\n\tExiting Program...\n\n\n");
                keepGoing = false;
            }
            else {

                out.print("Insert a height of a triangle: ");
                height = input.nextFloat();
                
                out.printf("Triangle Area: %.5f\nTriangle Perimeter: %.5f\n\n\n\n", base*height/2, base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));
            }
            

        }
    }

}
