import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void printAgeDistribution(int age){

        if(age<0 || age>100) {
            System.out.println("This program is for humans");
        } else if (age>=0 && age <=2) {
            System.out.println("Still in Mama's arms");
        } else if (age==3 || age ==4) {
            System.out.println("Preschool Maniac");
        } else if (age>4 && age<12) {
            System.out.println("Elementary school");
        } else if (age>=12 && age<15) {
            System.out.println("Middle school");
        } else if (age>=15 && age<=18) {
            System.out.println("High school");
        } else if (age>=19 && age<=22) {
            System.out.println("College");
        } else if (age>=23 && age<=65) {
            System.out.println("Working for the man");
        } else if (age>=66 && age<=100) {
            System.out.println("The Golden Years");
        }

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                       printAgeDistribution(Integer.parseInt(line)); 
                    
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

