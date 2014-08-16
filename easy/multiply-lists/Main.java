import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static int[] multiplyLists(String[] list1, String[] list2) {

        int[] result = new int[list1.length];

        for(int i=0; i<list1.length;i++) {

            result[i] = Integer.parseInt(list1[i])*Integer.parseInt(list2[i]);
        }

        return result;

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\|");
                String[] list1 = lineArray[0].trim().split("\\s");
                String[] list2 = lineArray[1].trim().split("\\s");
                if (lineArray.length > 0) {
                    int[] results = multiplyLists(list1, list2);
                    
                    for(int i=0;i<results.length;i++) {
                        System.out.print(results[i]);

                        if(i<results.length-1)
                            System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

