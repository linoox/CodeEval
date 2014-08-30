import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

public class Main {

    // will replaceing the inner for loop with 
    // a hashmap give v good results ?
    // we wont have to loop through the string just do a lookup?
    // ya hashmap gave slightly better performance 
    // but consumed slightly more memory.
    static void removeCharacters(String originalStr, String blist) {
        String result="";

        Map<Character,Integer> blacklist = new HashMap<Character,Integer>();
        for (int i=0;i<blist.length();i++) {
            char chr = blist.charAt(i);
            blacklist.put(chr,1);    
        }


        for (int j=0;j<originalStr.length();j++) {
            char ch = originalStr.charAt(j);
            if(!blacklist.containsKey(ch))
                result+=ch;
        }

        System.out.println(result);
    }



	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    String originalStr = lineArray[0].trim();
                    String blacklist = lineArray[1].trim();

                    removeCharacters(originalStr, blacklist);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

