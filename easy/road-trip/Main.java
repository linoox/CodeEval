import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static void findDistances(String[] strDistances) {
        int len = strDistances.length;
        int[] distances = new int[len];

        for (int i=0;i<len;i++) {
            distances[i] = Integer.parseInt(strDistances[i]);
        }

        Arrays.sort(distances);
        String output="";

        // feeling bored to format another loop for o/p.
        for (int j=len-1;j>0 ;j--) {
            distances[j] = distances[j] - distances[j-1]; 
            output = ","+ distances[j] + output;
        }

        output = distances[0]+output;
        
        System.out.println(output);
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                String[] distances = new String[lineArray.length];
                if (lineArray.length > 0) {
                    int i=0;
                    for(String str:lineArray){
                        String[] temp=str.split(",");
                        distances[i] = temp[1].trim();
                        i++;
                    }
                    findDistances(distances);

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

