import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	
	static int numberOfOnes(int number) {
	    
	    int count=0;

    	while(number != 0) {
    		if((number & 1) > 0)
    			count++;
    		number = number >> 1;
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
 					System.out.println(numberOfOnes(Integer.parseInt(line)));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

