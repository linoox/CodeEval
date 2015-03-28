import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int maxRangeSum(int days, int[] stockPrices){

        int maxProfit = 0;
        int startIdx = 0;
        int prevMaxProfit=0;

        for (int i=0;i<days;i++ ) {
            prevMaxProfit += stockPrices[i];
        }

        int oldSum=prevMaxProfit;

        for (int i=days;i<stockPrices.length;i++ ) {            
                       
            int newSum = oldSum+stockPrices[i]-stockPrices[i-days];
            oldSum = newSum;

            if (newSum > prevMaxProfit) {
                prevMaxProfit = newSum;
            }
        }

        return (prevMaxProfit > 0 ? prevMaxProfit : 0);

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                 String[] lineArray = line.split(";");
                 int days = Integer.parseInt(lineArray[0]);
                 String[] stockPricesStr = lineArray[1].split("\\s");
                 int[] stockPrices = new int[stockPricesStr.length];

                 for (int i=0;i<stockPrices.length;i++) {
                     stockPrices[i] = Integer.parseInt(stockPricesStr[i]);    
                 }                 

                 System.out.println(maxRangeSum(days, stockPrices));      
                    
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}
