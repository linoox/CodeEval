import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String switchLetterCase(String str) {

        StringBuffer sbuf = new StringBuffer();
        char switchChar;
        

        for (int i=0;i<str.length();i++) {
        
            char ch = str.charAt(i);

            if (ch >= 65 && ch <= 90) {
                    switchChar = (char)(ch+32);
                    sbuf.append(switchChar);
            }  else if (ch >= 97 && ch <= 122) {
                    switchChar = (char)(ch-32);
                    sbuf.append(switchChar);
            }  else {
                sbuf.append(ch);
            }
            
        }

        return sbuf.toString();
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(switchLetterCase(line));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

