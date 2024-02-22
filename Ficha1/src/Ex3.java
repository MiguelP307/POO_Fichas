import static java.lang.System.out;

import java.util.Scanner;

public class Ex3 {
    
    public static boolean isOnInterval(int minValue, int maxValue, int value) {
        if(value <= maxValue && value >= minValue)
            return true;
        return false;
    }

    public static void main(String[] agrs){

        final int MAX_MARK = 20;
        final int MIN_MARK = 0;

        int[] numMakrs = new int[]{0,0,0,0};

        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);

        while(keepGoing){

            out.print("Insert a student mark (0 - 20): ");
            int currentMark = input.nextInt();

            if(isOnInterval(MIN_MARK, MAX_MARK, currentMark)) {
                if(currentMark < 15)
                    numMakrs[currentMark/5]++;
                else
                    numMakrs[3]++;
            }
            else if (currentMark < 0) {
                keepGoing = false;
            }
            else{
                out.println("Invalid mark");
            }

        }

        out.printf("[0-5[ : %d\n[5-10[ : %d\n[10-15[ : %d\n[15-20] : %d\n", numMakrs[0], numMakrs[1], numMakrs[2],numMakrs[3]);

    }

}
