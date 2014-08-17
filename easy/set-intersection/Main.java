import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void setIntersection(String[] list1, String[] list2) {

        // could have thought of some alternate way to implement.
        // but just wanted to use labels for fun because i have never 
        // used labels in the past

        boolean punctuationFlag=false;

        outerloop:
        for (int i=0; i<list1.length;)
            for (int j=0;j<list2.length; ) {
        
                if(Integer.parseInt(list1[i]) < Integer.parseInt(list2[j])){

                    i++;
                } else if(Integer.parseInt(list1[i]) > Integer.parseInt(list2[j])){
                    j++;
                } else {
                
                /*
                 * flag does not look elegant.
                 * also unnecessary operation of setting it to true
                 * in the loop.
                 * think of a condition that is false the first time
                 * and true always after that.
                 */
                if(punctuationFlag)
                    System.out.print(",");

                System.out.print(Integer.parseInt(list1[i]));
                punctuationFlag=true;

                i++;
                j++;

             }
        
                if( i == list1.length || j == list2.length) 
                    break outerloop; // labels for fun :)

        }
    }  



	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                String[] firstList = lineArray[0].split(",");
                String[] secondList = lineArray[1].split(",");
                if (lineArray.length > 0) {

                    setIntersection(firstList, secondList);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

