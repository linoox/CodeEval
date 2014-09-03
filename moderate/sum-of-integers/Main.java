import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static int maxContiguousSubArraySum(String[] numbersStr) {
        int maxSumIdx=0; //max Sum till the index
        int maxSum=0;
        int len = numbersStr.length;
        int[] numbers=new int[len];

        for (int i=0;i<len;i++) {
            numbers[i]  = Integer.parseInt(numbersStr[i].trim());
        }

        for (int i=0;i<len;i++) {

            maxSumIdx=Math.max(maxSumIdx+numbers[i],numbers[i]);
            
            if(maxSum < maxSumIdx) {
                 maxSum = maxSumIdx;
            }

        }

        return maxSum;
    }

    public static void main (String[] args) {


        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {

                    System.out.println(maxContiguousSubArraySum(lineArray));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}

