public class Main {

	public static int primePalindromeLessThan(int limit) {
		int SMALLEST_PRIME_PALINDROME = 2;

		for (int i=limit;i>0;i--) {
			
			if(isPrime(i)) {
				if(isPalindrome(i))
					return i;
			}
		}
		return SMALLEST_PRIME_PALINDROME;
	}

	public static boolean isPrime (int number) {
		
		for (int i=2;i<number;i++ ) {
			if(number%i == 0)
				return false;

		}

		return true;
	}

	public static boolean isPalindrome(int number) {
		int originalNumber = number;
		int reverseNumber=0;
		while(number != 0) {
			reverseNumber=reverseNumber*10;
			reverseNumber+=number%10;
			number=number/10;
		}
		if(reverseNumber == originalNumber) 
			return true;
		else return false;
	}


	public static void main(String[] args) {
		int number = 999;
		System.out.println(primePalindromeLessThan(number));
	}
}