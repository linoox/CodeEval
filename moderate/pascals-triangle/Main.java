import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //TODO: not an elegant solution. Write a new one.
    public static List<List<Integer>> generate(int numRows) {
     
    	List<List<Integer>> PT = new ArrayList<List<Integer>>();
    	
    	if(numRows == 0) return PT;
    	
    	List<Integer> baseList = new ArrayList<Integer>();
    	baseList.add(1);    	
    	PT.add(new ArrayList<Integer>(baseList));
    	if (numRows == 1) return PT;
    	
    	
    	baseList.add(1);
    	PT.add(new ArrayList<Integer>(baseList));
    	if (numRows == 2) return PT;
    	
    	for (int i=2;i<numRows;i++){
    		
    		int len = baseList.size();
    		//System.out.println("len:"+len);
    		List<Integer> baseListCopy = new ArrayList<Integer>();
    		
    		for (int j=0; j<len+1; j++) {
    			
    			if(j==0 || j == len) {
    				if (j == 0) {
    				//System.out.println("bl["+j+"]" + " = b["+j+"]" );
    				baseListCopy.add(j,baseList.get(j));
    				}
    				
    				if (j == len) {
        				//System.out.println("bl["+j+"]" + " = b["+j+"]" );
        				baseListCopy.add(j,baseList.get(j-1));
        				}
    				
    			} else {
    				//System.out.println("bl["+j+"]" + " = b["+(j-1)+"]+ b["+j+"]");
    				baseListCopy.add(j,baseList.get(j-1) + baseList.get(j));
    			}
    		}
    		baseList = baseListCopy;
    		PT.add(new ArrayList<Integer>(baseList));
    	}
    	
    	//System.out.println(PT);
    
    	return PT;
    }

        public static void main (String[] args) {

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();


        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                    int j=0;

                    triangle = generate(Integer.parseInt(line));
                    for(List<Integer> l:triangle) {
                        if(j > 0 ) {
                                System.out.print(" ");

                            }

                        for (int i=0;i<l.size();i++) {
                            if(i !=0 ) {
                                System.out.print(" ");

                            }
                            System.out.print(l.get(i));
                                
                        }
                        j++;
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}