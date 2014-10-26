import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static String readMore(String line) {
		String adjustedLine = "";

		if(line.length() <= 55) {
			return line;
		} else if (line.charAt(40)==' '){
			adjustedLine = line.substring(0,40);
			adjustedLine = adjustedLine+"... <Read More>";
		} else {
			adjustedLine = line.substring(0,40);
			int i=39;

			if(adjustedLine.indexOf(' ') < 0) {
				adjustedLine = adjustedLine+"... <Read More>";
				return adjustedLine;
			}


			while(adjustedLine.charAt(i) != ' ') {
				i--;
			}
			adjustedLine = line.substring(0,i);
			adjustedLine = adjustedLine+"... <Read More>";
		}

		return adjustedLine;

	}

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(readMore(line));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

