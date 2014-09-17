import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //TOOD: cleaner impl
    public static boolean validateEmailAddress(String emailaddress) {

        String emailValidPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,6})$";

        
        Pattern pattern = Pattern.compile(emailValidPattern);
        Matcher matcher = pattern.matcher(emailaddress);
        return matcher.matches();

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {

                if (line.length() > 0) {

                    //System.out.println(validateEmailAddress(String emailaddress)); 
                    System.out.println(validateEmailAddress(line));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

