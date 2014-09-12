import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static void queryBoard(int[][] queryBoard, List<String> instructions) {
    
        int col=0;
        int row=0;
        int val=0;

        for (String instr : instructions) {
             String[] exp = instr.split("\\s");  

             String operation = exp[0];

            if(operation.equals("SetCol")) {
                col = Integer.parseInt(exp[1]);
                val = Integer.parseInt(exp[2]);

                for (int i=0;i<256;i++) {
                    queryBoard[i][col] = val;
                }

            } else if(operation.equals("SetRow")) {
                row = Integer.parseInt(exp[1]);
                val = Integer.parseInt(exp[2]);

                for (int i=0;i<256;i++) {
                    queryBoard[row][i] = val;
                }

            } else if(operation.equals("QueryCol")) {
                col = Integer.parseInt(exp[1]);
                int sum=0;
                
                for (int i=0;i<256;i++) {
                    sum += queryBoard[i][col];
                }

                System.out.println(sum);

            } else if(operation.equals("QueryRow"))  {
                row = Integer.parseInt(exp[1]);
                int sum=0;

                for (int i=0;i<256;i++) {
                    sum += queryBoard[row][i];
                }

                System.out.println(sum);
            }

        }

    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            List<String> instructions = new ArrayList<String>();
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                            
                    instructions.add(line);
                }
            }

            int[][] board = new int[256][256];
            //for (int[] row : board)
            //Arrays.fill(row, 0);

            queryBoard(board, instructions);

        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

