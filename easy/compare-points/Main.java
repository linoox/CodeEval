import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
public static String getDirection(int o, int p, int q, int r) {
		 String dir = "";
		 if (o == q) {
			 if (r > p) {
				 dir= "N";
			 } else if (r < p) {
				 dir= "S";
			 } else {
				 dir = "here";
			 }
		 }
		 
		 if (r == p) {
			 if (q > o) {
				 dir= "E";
			 } else if (q < o) {
				 dir= "W";
			 } else {
				 dir = "here";
			 }
		 }
	
		 if (q > o) {
			 if (r < p) {
				 dir= "SE";
			 } else if (r >p) {
				 dir= "NE";
			 } else {
			 	dir = "E";
			 }
		 }
		 
		 if (q < o) {
			 if (r > p) {
				 dir= "NW";
			 } else if ( r < p) {
				 dir= "SW";
			 } else {
			 	dir = "W";
			 }
		 }
		 
		 return dir;
}


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                 String[] coOrdinates = line.split("\\s");

		int o = Integer.parseInt(coOrdinates[0]);
		int p = Integer.parseInt(coOrdinates[1]);
		int q = Integer.parseInt(coOrdinates[2]);
		int r = Integer.parseInt(coOrdinates[3]);
		
		System.out.println(getDirection(o,p,q,r));

                    
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}