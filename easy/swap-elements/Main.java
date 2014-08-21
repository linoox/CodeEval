import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static int[] swapElements(String[] numbersAsStrings, String[] swaps) {
        int len = numbersAsStrings.length;
        int[] numbers =  new int[len];

        for (int i=0;i<len;i++ ) {
            numbers[i] =  Integer.parseInt(numbersAsStrings[i].trim());
        }

        for (String swp : swaps) {
            String[] positions=swp.split("-");
            int pos1 = Integer.parseInt(positions[0].trim());
            int pos2 = Integer.parseInt(positions[1].trim());
            int temp = numbers[pos1];
            numbers[pos1] = numbers[pos2];
            numbers[pos2] = temp;
        }


        return numbers;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(":");
                if (lineArray.length > 0) {

                    String[] numbers = lineArray[0].split("\\s");
                    String[] swaps = lineArray[1].trim().split(",");

                    int[] swappedList = swapElements(numbers, swaps);

                    //System.out.println(Arrays.toString(swappedList));
                    for (int i=0;i<swappedList.length;i++) {
                         if(i>0) {
                            System.out.print(" ");
                         }   

                         System.out.print(swappedList[i]);
                    }

                    System.out.println();

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

