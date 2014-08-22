import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static boolean isStringRotation(String original, String str) {

        String concatenatedString = original+original;
        if (concatenatedString.indexOf(str) >= 0) {
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

                    if (isStringRotation(lineArray[0],lineArray[1])) {
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

