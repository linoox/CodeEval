import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

// CLRS quicksort
public class Main {

    static void quicksort(double[] A, int p, int r) {

        if(p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
        }
    }

    static void swap(double[] A, int i, int j) {
        double temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int partition(double[] A, int p, int r) {
        double x = A[r];
        int i = p-1;
        for (int j=p; j <= r-1; j++) {
            if(A[j] <= x) {
                i=i+1;
                swap(A, i, j);
            }
        }
        swap(A,i+1,r);
        return i+1;
    }

    static double[] sort(double[] A) {
        //double[] sortedArray = quicksort(A);
        // return sortedArray;
        quicksort(A,0,A.length-1);
        return A;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    double[] arr = new double[lineArray.length];

                    for (int i=0;i<lineArray.length;i++) {
                        arr[i] = Double.parseDouble(lineArray[i]);    
                    }
                    // System.out.println("Array: "+Arrays.toString(arr));
                    // System.out.println(Arrays.toString(sort(arr)));
                    
                    sort(arr);

                    for (int i=0;i < arr.length;i++) {
                        if(i > 0)
                            System.out.print(" ");
                        System.out.print(String.format("%.3f",arr[i]));
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

