import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static boolean isEven(int number) {

        return (number%2 == 0)?true:false;
        
    }


    public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    if ( isEven(Integer.parseInt(lineArray[0]))) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");    
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }    


}

