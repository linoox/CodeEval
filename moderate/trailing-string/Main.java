import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // bug fixed:
    // taking negative val of idx into consideration.
    // without that following case would fail
    // Mountain view CA,Mountain view CAR would fail.
    // og.len:16| idx:-1| substr.len17

    public static int hasTrailingString(String original, String substr) {

        int idx = original.lastIndexOf(substr);
        //System.out.println("og.len:"+original.length() + "| idx:"+idx+"| substr.len"+substr.length());

         if(idx<0) {
             return 0;
         }

        if((original.length() - idx) == substr.length()) {
            return 1;
        } else {
            return 0;
        }
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if(line.trim().length()>0) {
                    String[] lineArray = line.split(",");
                    if (lineArray.length > 0) {
                        System.out.println(hasTrailingString(lineArray[0],lineArray[1]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

