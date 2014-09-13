import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    // TODO: improve. naive impl
    public static void countPrimesBetween(int start, int end) {
        
        int[] primearray= new int[end+1];
        int prime=2;
        Arrays.fill(primearray, 1);
        int primeCount=0;
        
        primearray[0]=0;
        primearray[1]=0;
        
        for(int i=1;i<=end;i++) {
            
            if(primearray[i] != 0) {
                prime = i;

                if(i>=start && i<=end)
                    primeCount++;
                
                for(int j=prime; j*prime <=end; j++) {
                    primearray[prime*j]=0;
                }
            }
        }
        
        System.out.println(primeCount);
        
    }


    public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (line.length() > 0) {
                    
                    countPrimesBetween(Integer.parseInt(lineArray[0]),Integer.parseInt(lineArray[1]));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}
