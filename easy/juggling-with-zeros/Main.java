import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void getBinaryForm(String input) {
        String[] sequence = input.split("\\s");
        String binaryForm = "";

        for (int i=0;i<sequence.length;i+=2) {
            if(sequence[i].equals("00")) {
                binaryForm+=sequence[i+1].replace("0","1");
            } else if (sequence[i].equals("0")) {
                binaryForm+=sequence[i+1];
            }
        }

        System.out.println(Long.parseLong(binaryForm,2));

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {

                if (line.length() > 0) {

                    getBinaryForm(line);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

