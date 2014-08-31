import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            int lastEntryPoint = -1;
            int currentEntryPoint = -1;
            while ((line = in.readLine()) != null) {
                //System.out.println("lep: "+lastEntryPoint);
                if (line.length() > 0) {

                    if((currentEntryPoint = line.indexOf('C')) >= 0) {
                        
                        if(currentEntryPoint < lastEntryPoint) {
                            line = line.replace("C","/");
                            System.out.println(line);
                        }
                        else if (currentEntryPoint > lastEntryPoint) {
                            line = line.replace("C","\\");
                            System.out.println(line);
                        }
                        else  {
                            line = line.replace("C","|");
                            System.out.println(line);
                        }
                    }
                    else {
                        currentEntryPoint = line.indexOf('_');

                        if((lastEntryPoint != -1) && (currentEntryPoint < lastEntryPoint)){
                            line = line.replace("_","/");
                            System.out.println(line);
                        }
                        else if ((lastEntryPoint != -1) && (currentEntryPoint > lastEntryPoint)) {
                            line = line.replace("_","\\");
                            System.out.println(line);
                        }
                        else {
                            line = line.replace("_","|");
                            System.out.println(line);
                        }

                    }
                    
                    lastEntryPoint = currentEntryPoint;
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

