import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


// v ugly brute force code.. 
// need to rewrite

public class Main {

    static String getColumnNames(int number){

        String str = "";

        if (number <= 26) {            
            char ch = (char) (64+ number);
            return  str+ch;   
        } else if (number >26 && number <=26*26) {
            char ch = (char) (64 + (number%26 == 0 ? 26 : number%26));            
            str += ch;
            number = number - (number%26 == 0 ? 26 : number%26);            
            ch = (char) (64 + number/26);            
            return ch+str;        
        } else {
            char ch = (char) (64 + (number%26 == 0 ? 26 : number%26));            
            str += ch;
            number = number - (number%26 == 0 ? 26 : number%26);            
             
            for (int i=1; i<=26; i++) 
                for (int j=1; j<=26; j++ ) {

                    if (Math.pow(26,2)*i + 26*j == number)  {

                        ch = (char) (64 + j);
                        str = ch + str;
                        ch = (char) (64 + i);
                        str = ch + str;
                        return str;
                    }

                }    
        }
        
        return str;
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                System.out.println(getColumnNames(Integer.parseInt(line))); 
                    
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}
