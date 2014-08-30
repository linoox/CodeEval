import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {

    static void removeCharacters(String originalStr, String blacklist) {
        String result="";
        int i=0;        

        for (int j=0;j<originalStr.length();j++) {
            char ch = originalStr.charAt(j);

            for(i=0;i<blacklist.length();i++) {
                if(ch == blacklist.charAt(i)) {
                    break;
                }
            }

            if(i == blacklist.length())
                result+=ch;
        }

        System.out.println(result);
    }



	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    String originalStr = lineArray[0].trim();
                    String blacklist = lineArray[1].trim();

                    removeCharacters(originalStr, blacklist);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

