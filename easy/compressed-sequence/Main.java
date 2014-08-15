import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.LinkedHashMap;

public class Main {

    /* not using a dict 
    static void compressedSequence(String[] line) {

        int count=0;

        Map<String,Integer> seqCount = new LinkedHashMap<String,Integer>();
        for(String str:line) {
            count=0;

            if (seqCount.get(str) == null) {
                seqCount.put(str,1);
            } else {
                count = seqCount.get(str)+1;
                seqCount.put(str,count);
            }
        }

        System.out.print(seqCount);

        //printing the compressed sequence.

    }
    */

    static void compressedSequence(String[] line) {
        int count=1;
        String str="";
        str=line[0];

        for (int i=1;i<line.length;i++) {
            if(str.equals(line[i]))
                count++;
            else {
                System.out.print(count+" "+str+" ");
                count=1;
                str=line[i];
            }
        }

        // for the last number/only number
        System.out.print(count+" "+str);

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    compressedSequence(lineArray);
                    System.out.println();

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

