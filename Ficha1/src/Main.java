import java.lang.String;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.DateTimeException;

import static java.lang.System.out;;

public class Main {

    public static String calculateWeekDay(LocalDate date){

        int result = 0;

        result = (date.getYear() - 1900)*365 + (date.getYear()-1900)/4;
        
        if(date.getYear()%4 == 0 && (date.getMonth().getValue() == 1 || date.getMonth().getValue() == 2)) {
            result--;
        }

        result += date.getDayOfYear();
        result = result % 7;


        switch(result) {
            case 0:
                return "Domingo";

            case 1:
                return "Segunda";

            case 2:
                return "Terca";

            case 3:
                return "Quarta";
            
            case 4:
                return "Quinta";

            case 5:
                return "Sexta";

            case 6:
                return "Sabado";

            default:
                break;
        }
        
        return "Failed";
    }

    public static int[] parseDate(String date){
        // Should be on the following format (dd/mm/yyyy)

        String[] sParts = date.split("/"); // Tokenize the string
        int[] parts = new int[3]; // Init the array

        for(int count = 0; count < 3; count++){
            parts[count] = Integer.valueOf(sParts[count]);
        }

        return parts;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean isValid = false;

        while(!isValid){

            out.print("Insert a data on the following format (dd/mm/yyyy): ");
            String str = input.nextLine();

            int[] parts = new int[3];
            parts = parseDate(str);

            //Check if the inserted date is valid
            try{
                LocalDate newDate = LocalDate.of(parts[2],parts[1], parts[0]);
                isValid = true;

                out.printf("O dia da semana da data %d/%d/%d e %s\n", newDate.getDayOfMonth(), newDate.getMonthValue(), newDate.getYear(), calculateWeekDay(newDate));
            }
            catch(DateTimeException e) {
                out.println("Invalide Date or Date Format, please try again");
            }

        }

        

    }
}