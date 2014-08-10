import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    /*
     * 
     * Left shifting n gives incorrect results.
     *
     */


    public static int multiplesOfNumber(int x, int n) {
        int num=n;
        
        while (true) {
            if(num>=x)
                break;
            num+=n;
        }
        return num;
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
                    int x = Integer.parseInt(lineArray[1]);
                    System.out.println(multiplesOfNumber(n,x));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

