import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Main {


    static class NumberPair {
        int number1;
        int number2;
        
        public NumberPair(int number1, int number2) {
            this.number1=number1;
            this.number2=number2;
        }
        
        public int getFirstNumber(){
            return number1;
        }
        
        public int getSecondNumber(){
            return number2;
        }
        
        public String toString() {
            // use string.format
            return number1+","+number2;
            
        }
    }
    
     
    static List<NumberPair> numberPairs (int[] numberList, int number ) {
        int number1;
        int number2;
        List<NumberPair> np =  new ArrayList<NumberPair>();
        //NumberPair pair= new NumberPair(number1, number2);

        for(int i=0;i<numberList.length;i++) {
            int num = numberList[i];
            //System.out.println("search for:"+(number-num)+" original number:"+num);
            int idx = Arrays.binarySearch(numberList,i+1,numberList.length,number-num);
            if(idx>=0) {
                int numComplement = numberList[idx];
                NumberPair pair= new NumberPair(num, numComplement);
                np.add(pair);
            } 
        }
            
        return np;
    }
    



	public static void main (String[] args) {


        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                sb.setLength(0);
                if (lineArray.length > 0) {
                    
                    int number = Integer.parseInt(lineArray[1]);
                    String[] numbersAsString = lineArray[0].split(",");
                    int[] numberList = new int[numbersAsString.length];

                    for(int i=0;i<numberList.length;i++) {
                        numberList[i]=Integer.parseInt(numbersAsString[i]);
                    }
                
                    List<NumberPair> np =  new ArrayList<NumberPair>();
                    np = numberPairs(numberList, number);
                
                    if(np.size() > 0) {

                        for(NumberPair pair: np) {
                            if(sb.length() != 0){
                                sb.append(";");
                            }
                            sb.append(pair);    
                        }
                    } else {
                        sb.append("NULL");
                    }
                    System.out.println(sb.toString()); 
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }    
	}
}

