import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

/* TLE */
public class Main {

    static int doubleSquares(int number) {
        
        //System.out.println("Test case - number:"+number);
        if(number == 0) return 1;

        Map<Integer, Integer> squaresTable = new HashMap<Integer, Integer>();
        int count=0;
        int A=0,B=0;

        int ASquare=0;
        int BSquare=0;
        
        while(ASquare <= number){

            B=0;
            BSquare=0;
            while(BSquare <= number) {
                //System.out.println("A: "+A+" | B: "+B);

                if(squaresTable.containsKey(A)) {
                    ASquare = squaresTable.get(A);
                } else {
                    ASquare = A*A;
                    squaresTable.put(A,ASquare);
                }
        
                if(squaresTable.containsKey(B)) {
                    BSquare = squaresTable.get(B);
                } else {
                    BSquare = B*B;
                    squaresTable.put(B,BSquare);
                }

                //System.out.println("ASquare: "+ASquare + " | BSquare: "+BSquare);

                if (ASquare+BSquare == number)
                    count++;

                B++;
            } 

            A++;
        }      

        // since we are counting twice. A: 0 -> 4, B: 0 -> 4
        // example: A=1,B=3 and A=3,B=1.
        // 0 is counted only once.
        return count/2;
    }

    public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            int numTestCases = Integer.parseInt(in.readLine());
            String line;
            while (numTestCases > 0) {
                
                line = in.readLine();
                System.out.println(doubleSquares(Integer.parseInt(line)));
                
                numTestCases--;
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}

