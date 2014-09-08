import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String cardinalToRoman(int number) {

        Map<Integer,String> romanNumset = new HashMap<Integer, String>();
        romanNumset.put(1,)


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

