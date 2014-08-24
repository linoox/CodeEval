import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String letterCasePercentageRatio(String str) {

        int countUpper=0;
        int countLower=0;

        for (int i=0;i<str.length();i++) {
        
            char ch = str.charAt(i);

            if (ch >= 65 && ch <= 90) {
                    countUpper++;
            }  else if (ch >= 97 && ch <= 122) {
                    countLower++;
            }  
            
        }

        float pctUpper=(100*countUpper/(float)(countLower+countUpper));
        float pctLower=(100*countLower/(float)(countLower+countUpper));

        String output = String.format("lowercase: %.2f uppercase: %.2f",pctLower,pctUpper);

        return output;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(letterCasePercentageRatio(line));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

