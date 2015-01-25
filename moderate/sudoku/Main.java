import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    // todo: can add to check in input val > size reject.
    public static boolean isValidSudokuBoard(int size, int[] board) {
        int gridSize=0;

        int[][] sudokuBoard = new int[size][size];
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                
                sudokuBoard[i][j]=board[size*i+j]; 
                if(sudokuBoard[i][j] > size) {
                    return false;
                }
                // System.out.print("  "+board[size*i+j]);
            } 
            // System.out.println();
        }    

        if(size == 4) {
            gridSize=2;
        } else if (size == 9){
            gridSize=3;
        }
        

        // every row has unique
        for (int i=0;i<size;i++) {
            int checker=0;
            
            for (int j=0;j<size;j++) {
            
                if((checker & (1 << sudokuBoard[i][j])) >0)
                    return false;
                checker |= (1 << sudokuBoard[i][j]);
            }

        }

        // every col has unique    
        for (int i=0;i<size;i++) {
            int checker=0;
            
            for (int j=0;j<size;j++) {
            
                if((checker & (1 << sudokuBoard[j][i])) >0)
                    return false;
                checker |= (1 << sudokuBoard[j][i]);
            }
            
        }



        // IMP: NOTE: if int checker was inside third loop 1/20 case fails.
        // 
        // System.out.println("Validating grids");
        // every box has unique
        for (int i=0;i<gridSize;++i) {
            for (int j=0;j<gridSize;++j) {
                int sum=0;
                int checker=0;
                for (int k=i*gridSize;k<i*gridSize+gridSize;++k) {
                    // int checker=0; <--- BUG!!!!
                    for (int l=j*gridSize;l<j*gridSize+gridSize;++l) {
                        if((checker & (1 << sudokuBoard[k][l])) >0)
                            return false;
                        checker |= (1 << sudokuBoard[k][l]);
                    }
                    
                }
                
            }
            
        }


        return true;
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                int boardSize = Integer.parseInt(lineArray[0]);
                String[] boardString = lineArray[1].split(",");
                int[] board = new int[boardString.length];

                for (int i=0;i<boardString.length;i++) {
                    board[i] = Integer.parseInt(boardString[i]);
                }
                //System.out.println(Arrays.toString(board));
                // read comma separated ints to avoid converting string to int.

                if (lineArray.length > 0) {
                    if(isValidSudokuBoard(boardSize,board)) {
                        System.out.println("True");    
                    } else {
                        System.out.println("False");
                    }
                    

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

