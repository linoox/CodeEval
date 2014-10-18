import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static int[] timeStringToInteger(String[] timeStr) {
        int len = timeStr.length;
        int[] time = new int[len];
        for (int i=0;i< len; i++) {
            time[i]=Integer.parseInt(timeStr[i]);
        }

        return time;
    }

    static String deltaTime(int[] time1, int[] time2) {

        int[] timediff = new int[3];

        timediff[2] = time1[2] - time2[2];
        if(timediff[2] < 0) {
            timediff[2]+=60;   
            time1[1]-=1;
        }

        timediff[1] = time1[1] - time2[1];
        if (timediff[1] < 0) {
            timediff[1]+=60;
            time1[0]-=1;        
        }    

        timediff[0] = time1[0] - time2[0];

        String sbuf="";
        sbuf = ""+String.format("%02d",timediff[0])+":"+String.format("%02d",timediff[1])+":"+String.format("%02d",timediff[2]);

        // System.out.println(Arrays.toString(timediff));
        

        return sbuf;

    }

    static String deltaTime(String[] strTime1, String[] strTime2) {

        int[] time1 = timeStringToInteger(strTime1);
        int[] time2 = timeStringToInteger(strTime2);
    
        String result = "";

        if(time1[0] > time2[0]) {
            result = deltaTime(time1,time2);
        } else {
            if((time1[0] == time2[0]) && (time1[1] > time2[1]))
                result = deltaTime(time1,time2);
            else {
                result = deltaTime(time2,time1);
            }
        } 

        return result;

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    String[] strTime1 = lineArray[0].split(":");
                    String[] strTime2 = lineArray[1].split(":");
                    
                    System.out.println(deltaTime(strTime1,strTime2));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

