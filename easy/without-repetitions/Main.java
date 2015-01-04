import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static void withoutRepetitions(String str) {
        char current = '0';
        char prev = '0';

        for (int i=0;i<str.length();i++) {
            
            current = str.charAt(i);

            if(current != prev) {
                System.out.print(current);
                prev = current;
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
                if (line.length() > 0) {

                    withoutRepetitions(line);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}

