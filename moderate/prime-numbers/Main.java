import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    
    public static void printPrimeNumbersUpto(int end) {
        
        int[] primearray= new int[end];
        int prime=2;
        Arrays.fill(primearray, 1);
        
        primearray[0]=0;
        primearray[1]=0;
        
        for(int i=1;i<end;i++) {
            
            if(primearray[i] != 0) {
                prime = i;
                
                if(i > 2)
                  System.out.print(",");

                System.out.print(prime);
                
                for(int j=prime; j*prime <end; j++) {
                    primearray[prime*j]=0;
                }
            }
        }
        
        
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                    //System.out.println("limit:"+Integer.parseInt(line));
                    printPrimeNumbersUpto(Integer.parseInt(line));
                    System.out.println();
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}
