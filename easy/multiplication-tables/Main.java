import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void printMultiplicationTables(int tableSize) {
        
        StringBuffer resultBuf = new StringBuffer();
        String row="";
        for (int i=1;i<=12;i++) {
            resultBuf.setLength(0);
            for (int j=1;j<=12;j++) {
                
                resultBuf.append(String.format("%4d",i*j));
                
            }
            row = resultBuf.toString();
            System.out.println(row.trim());
        }
    }

	public static void main (String[] args) {

        int tableSize=12;
            
        printMultiplicationTables(tableSize);

	}
}

