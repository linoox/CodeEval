import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

public class Main {

    // crappy code - just wrote hurriedly :P    

    static String[] printBigDigit(char ch) {

        String[] str = new String[1];

        switch(ch) {

            case '0': 
                    String[] s0 = new String[6];
                    s0[0] = "-**--";
                    s0[1] = "*--*-";
                    s0[2] = "*--*-";
                    s0[3] = "*--*-";
                    s0[4] = "-**--";
                    s0[5] = "-----";      
                    return s0;
            
            case '1': 
                    String[] s1 = new String[6];
                    s1[0] = "--*--";
                    s1[1] = "-**--";
                    s1[2] = "--*--";
                    s1[3] = "--*--";
                    s1[4] = "-***-";
                    s1[5] = "-----";
                    return s1;
            
            case '2': 
                    String[] s2 = new String[6];
                    s2[0] = "***--";
                    s2[1] = "---*-";
                    s2[2] = "-**--";
                    s2[3] = "*----";
                    s2[4] = "****-";
                    s2[5] = "-----";
                    return s2;                          
            
            case '3': 
                    String[] s3 = new String[6];
                    s3[0] = "***--";
                    s3[1] = "---*-";
                    s3[2] = "-**--";
                    s3[3] = "---*-";
                    s3[4] = "***--";
                    s3[5] = "-----";
                    return s3;

            case '4': 
                    String[] s4 = new String[6];
                    s4[0] = "-*---";
                    s4[1] = "*--*-";
                    s4[2] = "****-";
                    s4[3] = "---*-";
                    s4[4] = "---*-";
                    s4[5] = "-----";
                    return s4;
                    
            case '5': 
                    String[] s5 = new String[6];
                    s5[0] = "****-";
                    s5[1] = "*----";
                    s5[2] = "***--";
                    s5[3] = "---*-";
                    s5[4] = "***--";
                    s5[5] = "-----";
                    return s5;
                    
            case '6': 
                    String[] s6 = new String[6];
                    s6[0] = "-**--";
                    s6[1] = "*----";
                    s6[2] = "***--";
                    s6[3] = "*--*-";
                    s6[4] = "-**--";
                    s6[5] = "-----";
                    return s6;                     

            case '7': 
                    String[] s7 = new String[6];
                    s7[0] = "****-";
                    s7[1] = "---*-";
                    s7[2] = "--*--";
                    s7[3] = "-*---";
                    s7[4] = "-*---";
                    s7[5] = "-----";
                    return s7;

            case '8': 
                    String[] s8 = new String[6];
                    s8[0] = "-**--";
                    s8[1] = "*--*-";
                    s8[2] = "-**--";
                    s8[3] = "*--*-";
                    s8[4] = "-**--";
                    s8[5] = "-----";
                    return s8;
            
            case '9': 
                    String[] s9 = new String[6];
                    s9[0] = "-**--";
                    s9[1] = "*--*-";
                    s9[2] = "-***-";
                    s9[3] = "---*-";
                    s9[4] = "-**--";
                    s9[5] = "-----";
                    return s9;

        }

        return str; // should never reach here
    }

    static void printBigDigits(String input) {

        Map<Integer,String> BigDigit = new HashMap<Integer, String>();

        BigDigit.put(0,"");
        BigDigit.put(1,"");
        BigDigit.put(2,"");
        BigDigit.put(3,"");
        BigDigit.put(4,"");
        BigDigit.put(5,"");

        for (int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if(ch >= 48 && ch <= 57) {

                String[] row = printBigDigit(ch);

                String str0 = BigDigit.get(0);
                BigDigit.put(0,str0+row[0]);

                String str1 = BigDigit.get(1);
                BigDigit.put(1,str1+row[1]);
                
                String str2 = BigDigit.get(2);
                BigDigit.put(2,str2+row[2]);

                String str3 = BigDigit.get(3);
                BigDigit.put(3,str3+row[3]);

                String str4 = BigDigit.get(4);
                BigDigit.put(4,str4+row[4]);

                String str5 = BigDigit.get(5);
                BigDigit.put(5,str5+row[5]);    

            }
        }

        for (int i=0;i<6;i++) {
            
            System.out.println(BigDigit.get(i));
            
        }    


    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    printBigDigits(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

