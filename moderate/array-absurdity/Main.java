import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int arrayAbsurdity(int[] arr, int size) {
        int dupe=-1;
        
        int sumFormula = (size-2)*(size-1)/2; 
        int sumCalculated=0;
        
        for(int i=0; i<size;i++) {

            sumCalculated+=arr[i];
        }
        
        dupe=sumCalculated-sumFormula;
        
        return dupe;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                int size = Integer.parseInt(lineArray[0]);
                String[] numbers = lineArray[1].split(",");
                int[] arr = new int[numbers.length];

                if (lineArray.length > 0) {
                    
                    for (int i=0; i<numbers.length;i++ ) {
                        arr[i] = Integer.parseInt(numbers[i]);        
                    }

                    System.out.println(arrayAbsurdity(arr, size));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

