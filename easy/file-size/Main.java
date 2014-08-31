import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {

        File file = new File(args[0]);
        System.out.println(file.length());        

	}
}

