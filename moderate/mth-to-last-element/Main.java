import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    /*
     * Just to keep interface cleaner passing m
     * even though it can be evaluated from the 
     * passed list.
     *
     */
    static String mthToLast(String[] list, int m) {
        // System.out.println(Arrays.toString(list));
        // System.out.println("m:"+m);    

        int slowPtr = -1;
        int fastPtr = -1;

        for(int i=0;i<list.length-1;i++) {
            fastPtr++;
            if(fastPtr>=(m-1)) {
                slowPtr++;
            }
        }

        return list[slowPtr];
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    
                    int m = Integer.parseInt(lineArray[lineArray.length-1]);
                    if(m <= lineArray.length-1) {
                        System.out.println(mthToLast(lineArray, m));    
                    }
                    
                        
                }
            }

        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

