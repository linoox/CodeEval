import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String cardinalToRoman(int number) {

        String[] romanNumerals = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] cardinalNumbers = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String romanNumber = "";
        int power = 1;

        while(number != 0) {
            
            for (int i=cardinalNumbers.length-1;i>=0;) {
            
                if(number < cardinalNumbers[i]) {
                    i--;

                } else {
                    number = number - cardinalNumbers[i];
                    romanNumber += romanNumerals[i];
                }    
            }

        }

        return romanNumber;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(cardinalToRoman(Integer.parseInt(line)));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

