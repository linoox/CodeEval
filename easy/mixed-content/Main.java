import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static boolean isNumber(String input) {
        try {
                
            int i = Integer.parseInt(input);

        } catch (NumberFormatException nfe) {

            return false;
        }   
        return true; 
    }

    // neater way to identify string/number would 
    // have been regex.
    static void separateNumbersAndStrings(String[] lineArray) {


        int len = lineArray.length;
        String[] result = new String[len];
        boolean separator=false;
        boolean verticalSeparator=false;
        int i =0;

        
        for(i=0; i<len;i++) {
            if(!isNumber(lineArray[i])) {
                verticalSeparator = true;
                if(separator)
                    System.out.print(",");
                
                System.out.print(lineArray[i]);
                separator=true;

            }
        }

        
        
        separator=false;

        for(i=0; i<len;i++) {
            if(isNumber(lineArray[i])) {
                if(verticalSeparator)
                    System.out.print("|");

                if(separator)
                    System.out.print(",");

                System.out.print(lineArray[i]);
                separator=true;
                verticalSeparator=false;
            }
        }
        
        System.out.println();        
    
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\,");
                if (lineArray.length > 0) {

                    separateNumbersAndStrings(lineArray);

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

