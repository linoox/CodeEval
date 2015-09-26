import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class Main {

    static void detectCycle(String[] nums){
        
        Set<Integer> seenNumbers  = new HashSet<Integer>();
        Integer number = 0;;

        int[] numbers = new int[nums.length];


        for (int i=0; i< nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);    
        }
        
        int i=0,j=0;

        for (i=0; i<nums.length ; i++ ) {   
            
           //  System.out.println(" adding - " +numbers[i]);
                number = numbers[i];
            if (!seenNumbers.contains(number)) {
                seenNumbers.add(number);
                j++;
            } else {
                break;
            }
        }
        
         // System.out.println("number = "+number + " | j = "+j);
            // j--; 

        while (j >= 0) {            

           // System.out.print(" - "+numbers[j]);
            
            j--;
            if (numbers[j] == number)
                break;

        }        

        // System.out.println(" j ==> "+j+" | i ==> "+i);

        for (int k=j;k < i; k++) {
            if (k != j) {
                System.out.print(" ");
            }
            System.out.print(numbers[k]);   
        }

        System.out.println();
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                String[] nums = line.split("\\s+");
                // System.out.println(Arrays.toString(nums));
                
                detectCycle(nums);    
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}
