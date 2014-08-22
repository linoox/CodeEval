import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void decimalToBinary(int number) {

        if(number!=0) {
            int rem=number%2;
            number/=2;
            decimalToBinary(number);
            System.out.print(rem);    
        } 

        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                    if(Integer.parseInt(line) == 0) 
                        System.out.print("0");
                    decimalToBinary(Integer.parseInt(line));
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

