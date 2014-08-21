import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static String findWriter(String charset, String[] positions) {

        StringBuffer Author = new StringBuffer();

        for (int i=0;i<positions.length;i++) {
            Author.append(charset.charAt(Integer.parseInt(positions[i])-1));
        }
        System.out.println(Author);

        return null;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\|");
                
                if (lineArray.length > 0) {
                    String charset = lineArray[0];
                    String[] positions = lineArray[1].trim().split("\\s");

                    findWriter(charset, positions);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

