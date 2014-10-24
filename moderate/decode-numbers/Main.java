import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// passed cases 36/40
// to do:
//  logic is completely flawed
// consider cases like 100,1000,109,
public class Main {

	static int decodeNumbers(int number) {
		int count=0; // 1 - all individual numbers
		
		while(number > 0 ) {
			//System.out.println("nbr:"+number);
			if (number % 100 <= 26)
				count++;
			number = number/10;
		}
		
		return count;
	}

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                	System.out.println(decodeNumbers(Integer.parseInt(line)));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

