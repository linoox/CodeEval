import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    // very confusing problem statement :S
    // enum open/close true/false
    public static int findOpenDoors(int numDoors, int iterations){
        numDoors=numDoors+1; //to index from 1
        iterations=iterations+1; //to index from 1
        int numUnlockedDoors=0;

        boolean[] doors = new boolean[numDoors];
        Arrays.fill(doors,Boolean.TRUE);

        for (int i=1;i<iterations-1;i++) {
            //System.out.println("iter num:"+i);

            for (int k=1;k<numDoors;k++) {
                if(k%2 == 0)  {
                    //System.out.println("doors["+k+"]  -> false");
                    doors[k] = false;
                }
            }

            for (int j=1;j<numDoors;j++) {
                if(j%3 == 0) {
                    //System.out.print("i:"+i+" | j: "+j+ " | ");
                    if(doors[j] == true) {
                      //System.out.println("doors["+j+"] true -> false");
                        doors[j] = false;
                    } else {
                        //System.out.println("doors["+j+"] false -> true");
                        doors[j] = true;
                    }
                } 
            }
        }

        // last iter
        
        if(doors[numDoors-1] == true) {
            doors[numDoors-1] = false;
        } else {
            doors[numDoors-1] = true;
        }
        

        for (int k=1;k<numDoors;k++) {
            if(doors[k] == true) {
                numUnlockedDoors++;
            }
        }

        return numUnlockedDoors;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    System.out.println(findOpenDoors(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1])));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

