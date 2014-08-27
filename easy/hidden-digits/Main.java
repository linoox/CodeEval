import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void hiddenDigits(String str) {

        int OFFSET = 97;
        String result = "";

        for (int i=0;i<str.length();i++) {
        
            char ch = str.charAt(i);

            if (ch >= 97 && ch <= 106) {
                result += (int)(ch-OFFSET);
            }  else if (Character.isDigit(ch)) {
                result += Character.getNumericValue(ch);     
            }  
            
        }

        if(result.equals("")) {
            System.out.println("NONE");    
        } else {
            System.out.println(result);
        }
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {

                if (line.length() > 0) {

                    hiddenDigits(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

