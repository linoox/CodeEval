import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static long splitNumber(long number, String pattern) {
        long sum=0;
        // look ahead look behind
        String[] parts=pattern.split("((?<=\\+|\\-)|(?=\\+|\\-))");
        String part1=parts[0];
        String op=parts[1];
        String part2=parts[2];
    
        long number1=(long) (number/Math.pow(10,part2.length()));
        long number2=(long) (number % Math.pow(10,part2.length()));


        if(op.equals("+")) {
            sum = number1+number2;
        } else if (op.equals("-")) {
            sum = number1-number2;
        }
        
        return sum;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                long number = Long.parseLong(lineArray[0]);
                String pattern = lineArray[1];

                System.out.println(splitNumber(number, pattern));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

