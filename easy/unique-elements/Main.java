import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void printUniqueElements(String[] numbers) {
        String lastNumber = "";
        for (int i=0;i< numbers.length; i++) {
        
            if(!numbers[i].equals(lastNumber)) {
                lastNumber=numbers[i];
                if(i != 0) {
                    System.out.print(",");
                }
                System.out.print(numbers[i]);
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
                if (lineArray.length > 0) {

                    printUniqueElements(lineArray);

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

