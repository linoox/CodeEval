import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int minCoins(int amount) {
        int[] currency = {5,3,1};
        int count = 0;

        for (int i=0;i<currency.length;i++) {
            if(amount >= currency[i]) {
                count += amount / currency[i];
                amount %= currency[i];
            } else {
                // go to next denom
            }
        }
        return count;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {

                    System.out.println(minCoins(Integer.parseInt(line)));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

