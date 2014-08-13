import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    //TODO:
    // reduce no. of mod
    // caching?
    public static boolean isPrime(int number) {

        for(int i=2;i<number;i++) {
            if(number%i == 0)
                return false;
        }

        return true;
    }   


    public static int sumOfPrimes(int limit) {

        int sum=0;
        int i=2;
        int counter=0;

            while(counter < limit) {
                
                if(isPrime(i)) {
                    sum+=i;
                    counter++;
                }
                i++;

            }
        return sum;
    }

	public static void main (String[] args) {

        System.out.println(sumOfPrimes(1000));                    
        
	}
}

