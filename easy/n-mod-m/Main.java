import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    /*
     * For positive integers.
     * therefore ignoring cases where either n or m could be 0.
     * todo: complete this to make it a complete mod for -ve & 0
     */
    public static int mod(int n, int m) {

        if(n < m) return n;

        while (n >= m) {
           n = n-m; 
        }
        
        return (n==m?0:n);
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    int n = Integer.parseInt(lineArray[0]);
                    int m = Integer.parseInt(lineArray[1]);
                    System.out.println(mod(n,m));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

