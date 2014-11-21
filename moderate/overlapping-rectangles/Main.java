import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // todo: only 85% cases passed.
    static boolean overlappingRectangles(int[] points) {
        int rectA_UL_x = points[0];
        int rectA_UL_y = points[1];
        int rectA_LR_x = points[2];
        int rectA_LR_y = points[3];

        int rectB_UL_x = points[4];
        int rectB_UL_y = points[5];
        int rectB_LR_x = points[6];
        int rectB_LR_y = points[7];

        if(rectA_UL_x > rectB_LR_x || rectB_UL_x > rectA_LR_x)
            return false;

        if(rectA_UL_y < rectB_LR_y || rectB_UL_y < rectA_UL_y)
            return false;

        return true;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(",");
                int[] points = new int[8];

                for (int i=0;i<lineArray.length;i++) {
                    points[i] = Integer.parseInt(lineArray[i]);
                }


                if (lineArray.length > 0) {

                    if(overlappingRectangles(points)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

