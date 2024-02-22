import java.util.Scanner;
import static java.lang.System.out;
import java.lang.String;

public class Ex2 {
    
    public static String sumDates(String date1, String date2) {

        /* finalDate[0] --> DAY
         * finalDate[1] --> Hours
         * finalDate[2] --> Minutes
         * finalDate[3] --> Seconds
        */

        final int MAX_SECONDS = 60;
        final int MAX_MINUTES = 60;
        final int MAX_HOURS = 24;

        int[] finalDate = new int[4];
        int[] d1 = new int[4];
        int[] d2 = new int[4];
        
        // Tokenize the strings 
        String[] d1Str = date1.split(":");
        String[] d2Str = date2.split(":");

        // Cast the string values to integer ones
        for(int count = 0; count < 4; count++){
            d1[count] = Integer.valueOf(d1Str[count]);
            d2[count] = Integer.valueOf(d2Str[count]);
        }

        finalDate[3] = (d1[3] + d2[3]) % MAX_SECONDS;
        finalDate[2] = ((d1[2] + d2[2]) % MAX_MINUTES) + (d1[3] + d2[3])/MAX_SECONDS;
        finalDate[1] = ((d1[1] + d2[1]) % MAX_HOURS) + (d1[2] + d2[2])/MAX_MINUTES;
        finalDate[0] = d1[0] + d2[0] + (d1[1] + d2[1])/MAX_HOURS;

        return (String.valueOf(finalDate[0]) + "D " + String.valueOf(finalDate[1]) + "H " + String.valueOf(finalDate[2]) + "M " + String.valueOf(finalDate[3]) + "S\n");  
    };

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        out.println("Insert a date on the following format (Dd:HH:mm:ss) :");
        String date1 = input.nextLine();

        out.println("Insert another date on the following format (Dd:HH:mm:ss) :");
        String date2 = input.nextLine();

        out.printf(sumDates(date1,date2));   
    }
}
