import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String switchLetterCase(String str) {

        StringBuffer sbuf = new StringBuffer();
        char switchChar;
        boolean up=true;


        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);

            //System.out.println("ch: "+ch);

            if(up) {
                //System.out.println("convert ot upper");
                if((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
                    if (ch >= 97 && ch <= 122) {
                        ch = (char)(ch-32);
                    }        
                    up=false;
                }
                
                sbuf.append(ch);
                
            } else {
                //System.out.println("convert ot lower");
                if((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
                    if (ch >= 65 && ch <= 90) {
                        ch = (char)(ch+32);
                    } 
                    up=true;
                }
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

