import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int findRightMostOccurence(String string,  String charTofind) {
        int position=-1;
        int i=0;

        while(i < string.length()) {

            if(charTofind.equals(Character.toString(string.charAt(i)))) {
                position=i;
            }
            i++;
        }

        return position;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    String string = lineArray[0];
                    String charTofind = lineArray[1];

                    System.out.println(findRightMostOccurence(string, charTofind));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

