import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void reverse(String[] str){

        for (int i=str.length-1; i>=0 ;i-- ) {
            System.out.print(str[i]);
            
            if(i>0)
                System.out.print(" ");  
        }
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    reverse(lineArray);
                    System.out.println();
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

