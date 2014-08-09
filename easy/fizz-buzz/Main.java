

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {

		int divisorOne=1;
		int divisorTwo=1;
		int limit=1;
		
	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	            if (lineArray.length > 0) {
	                
	            	divisorOne=Integer.parseInt(lineArray[0]);
	            	divisorTwo=Integer.parseInt(lineArray[1]);
	            	limit=Integer.parseInt(lineArray[2]);
	            	
	            	for (int i=1;i<=limit;i++) {
	            	
				if(i != 1) {
					System.out.print(" ");
				}
	
	            		if((i%divisorOne==0) && (i%divisorTwo ==0)){ 
	            			System.out.print("FB");
	            		} else if (i%divisorOne==0) {
	            			System.out.print("F");
	            		} else if (i%divisorTwo == 0) {
	            			System.out.print("B");
	            		} else {
					System.out.print(i);
				}
				
	            	}
	            	
	            	System.out.println("\n");
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
}

