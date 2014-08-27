import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * TODO: Caching. some numbers will eventually sum up 
 *       to existing series which leads to palindrome.
 *       will probably need to store the number & steps
 */

public class Main {

    public static boolean isPalindrome(long number) {
        long originalNumber = number;
        long reverseNumber=0;
        while(number != 0) {
            reverseNumber=reverseNumber*10;
            reverseNumber+=number%10;
            number=number/10;
        }
        if(reverseNumber == originalNumber) 
            return true;
        else return false;
    }    


    public static long reverse(long num) {

        long reversedNumber = 0;
        while (num != 0) {
            reversedNumber = reversedNumber * 10 + num % 10;
            num = num / 10;
        }
        return reversedNumber;
    }

    public static void reverseAndAdd(long number) {
        //boolean palindrome = false;
        int steps = 0;
        long reversedNumber=0;
        
        while(true) {
            
            number  += reversedNumber;
            if(isPalindrome(number)) {
                break;
            }
            steps++;
            reversedNumber = reverse(number);
            
        }

        System.out.println(steps+" "+number);

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    reverseAndAdd(Long.parseLong(line));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

