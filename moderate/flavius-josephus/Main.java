import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void josephus(int n, int m) {

        int[] table = new int[n];
        for (int i=0; i < n; i++) {
            table[i] = i;
        }

        int alive = n;
        int i = 0;
        int last = 0;
        int dead = 0;
        int count = 0;

        while ( alive > 0) {
    
            i = i % n;
            if (table[i] == -1) {
                // skip and go to next table
                i++;
            
            } else {
                
                i++;
                count++;

                if(count == m) {
                    System.out.print(table[i-1] + " ");
                    table[i-1] = -1;
                    count = 0;
                    alive--;
                }

            }
            
        }

        System.out.println();
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                int n = Integer.parseInt(lineArray[0]);
                int m = Integer.parseInt(lineArray[1]);
                
                josephus(n,m);
                }
            } 
         catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}
