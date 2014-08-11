import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


public class Main {

    // TODO:  modify to return an int.
    // and print int.
    public static void printWordToDigit(String[] words) {

        Map<String,Integer> wordDigitPair = new HashMap<String, Integer>();
        // Initialize HM
        wordDigitPair.put("zero",0);
        wordDigitPair.put("one",1);
        wordDigitPair.put("two",2);
        wordDigitPair.put("three",3);
        wordDigitPair.put("four",4);
        wordDigitPair.put("five",5);
        wordDigitPair.put("six",6);
        wordDigitPair.put("seven",7);
        wordDigitPair.put("eight",8);
        wordDigitPair.put("nine",9);

        for (String word: words) {
            System.out.print(wordDigitPair.get(word));
        }

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                if (lineArray.length > 0) {

                    printWordToDigit(lineArray);
                    System.out.println();

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

