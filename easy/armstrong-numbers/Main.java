import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int getNumberOfDigits(int number) {
        int pow=1;
        int i=0;

        while(number >= pow) {
            pow*=10;
            i++;
        }
        return  i;
    }

    static boolean isArmstrong(int number) {
        int sum=0;
        int originalNumber=number;
        int power = getNumberOfDigits(number);


        while(number != 0) {
            int digit=number%10;
            sum+=(int)Math.pow(digit,power);
            number/=10;
        }

        if(sum == originalNumber) return true;
        else return false;
 
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    if(isArmstrong(Integer.parseInt(lineArray[0]))){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

