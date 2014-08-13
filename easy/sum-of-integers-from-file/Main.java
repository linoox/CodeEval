import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {
        int sum=0;

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    
                    sum+=Integer.parseInt(lineArray[0]);

                }
            }
            
            System.out.println(sum);

        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

