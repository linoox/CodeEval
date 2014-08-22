import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class Main {

    static char firstNonRepeatedCharacter(String str) {

        Map<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();
        for(int i=0; i<str.length();i++) {
            char ch = str.charAt(i);
            if(charCount.containsKey(ch)) {
                int count = charCount.get(ch);
                charCount.put(ch, count+1);
            } else {
                charCount.put(ch, 1);
            }
        }

        //System.out.println(charCount);

        Iterator<Character>chars = charCount.keySet().iterator();
        while(chars.hasNext()) {
            char ch1 = chars.next();
             if (charCount.get(ch1) == 1) {
                 return ch1;
             } 
                
        }
        return '0';
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {

                    System.out.println(firstNonRepeatedCharacter(line));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

