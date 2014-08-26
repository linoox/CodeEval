import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String isPangram(String str) {
        int UPPEROFFSET = 65;
        int LOWEROFFSET = 97;
        int NUM_OF_ALPHABETS=26;
        int index=0;
        int[] digitCount = new int[NUM_OF_ALPHABETS];
        String output="";

        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
        
            if (ch >= 65 && ch <= 90) {
                index = ch-UPPEROFFSET;
                digitCount[index]+=1;
            }  else if (ch >= 97 && ch <= 122) {
                index = ch-LOWEROFFSET;
                digitCount[index]+=1;
            }
        }
        
        //System.out.println(Arrays.toString(digitCount));

        //for(int j=0; j<NUM_OF_ALPHABETS;j++)
        for (int j=0;j<NUM_OF_ALPHABETS;j++) {
            if(digitCount[j] == 0) {
                output += (char) (j+LOWEROFFSET);
            }
        }
        

        if(output.equals("")) {
            return "NULL";
        } else {
            return output;
        }

    }



	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    System.out.println(isPangram(line));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

