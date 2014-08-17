import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;


public class Main {

    static int hexToDec(String hexNbr) {
        int dec=0;

        Map<Character,Integer> hexNumSet = new HashMap<Character, Integer>();
        hexNumSet.put('0',0);
        hexNumSet.put('1',1);
        hexNumSet.put('2',2);
        hexNumSet.put('3',3);
        hexNumSet.put('4',4);
        hexNumSet.put('5',5);
        hexNumSet.put('6',6);
        hexNumSet.put('7',7);
        hexNumSet.put('8',8);
        hexNumSet.put('9',9);
        hexNumSet.put('a',10);
        hexNumSet.put('b',11);
        hexNumSet.put('c',12);
        hexNumSet.put('d',13);
        hexNumSet.put('e',14);
        hexNumSet.put('f',15);


        for(int i=hexNbr.length()-1;i>=0;i--){
            // System.out.println("curr:"+hexNumSet.get(hexNbr.charAt(i)));
            // System.out.println("pow:"+Math.pow(16,hexNbr.length()-i));
            dec += hexNumSet.get(hexNbr.charAt(i))*Math.pow(16,hexNbr.length()-1-i);
        }

        return dec;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(hexToDec(line));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

