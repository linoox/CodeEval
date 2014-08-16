import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {



    static boolean sameBits(int number, int x, int y) {
        int x_bit = (int) Math.pow(2.0,(x-1));
        int y_bit = (int) Math.pow(2.0,(y-1));
        
        // () around & necessary has == has higher priority than &
        if(((number&x_bit) >0 && (number&y_bit)>0) || ((number&x_bit) == 0 && (number&y_bit)==0)){
            return true;
        } else {
            return false;
        }
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    
                    int number=Integer.parseInt(lineArray[0]);
                    int x=Integer.parseInt(lineArray[1]);
                    int y=Integer.parseInt(lineArray[2]);
                    
                    System.out.println(sameBits(number,x,y));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

