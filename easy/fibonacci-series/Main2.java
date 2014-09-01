import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    /*
     * Returns the nth-fibonnaci number.
     */
    public static int fibonacci (int number) {
        if(number==0) return 0;
        if(number==1) return 1;
        
        return fibonacci(number-1)+fibonacci(number-2);

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    
                    System.out.println(fibonacci(Integer.parseInt((lineArray[0]))));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

