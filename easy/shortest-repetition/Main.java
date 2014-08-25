import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int shortestRepetition (String str) {
        int period = 1;

        for (int i=1;i<str.length();i++) {
            if(str.charAt(i) != str.charAt(0)){
                period+=1;
            } else {
                break;
            }
        }

        return period;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    System.out.println(shortestRepetition(line));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

