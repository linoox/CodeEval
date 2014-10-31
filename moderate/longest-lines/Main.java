import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Comparator;
import java.util.PriorityQueue;


//todo: reverse sort in comparator could be written in better way?
public class Main {

    static class StringLengthComparator implements Comparator<String> {

        public int compare(String x, String y) {
            return -1*(x.length() - y.length());
        }
    }


	public static void main (String[] args) {

        
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(11,comparator);

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            
            int N = Integer.parseInt(in.readLine());

            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                    queue.add(line);
                }
                
            }

            for(int i=0;i<N;i++) {
                System.out.println(queue.remove());
            }

        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
        
        

	}
}

