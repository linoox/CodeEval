public class Main {

	public static void oddNumbers(int start, int limit) {
		
		while (start <= limit) {
			if((start % 2 == 1))
				System.out.println(start);
			start++;
		}
	}

	public static void main(String[] args) {
		
		int start = 1;
		int limit = 100;

		oddNumbers(start,limit);
	}
}