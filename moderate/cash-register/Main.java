import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

    public static void change(Double purchasePrice, Double cash) {

        Double[] currencyMap = new Double[]{100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.50,0.25,0.10,0.05,0.01};
        String[] currencyName = new String[]{"ONE HUNDRED","FIFTY","TWENTY","TEN","FIVE","TWO","ONE","HALF DOLLAR","QUARTER","DIME","NICKEL","PENNY"};
        DecimalFormat df = new DecimalFormat("#.##");
        //List<String> change = new ArrayList<String>();
        Double currency;
        int i=0;
        Double EPSILON = 0.000001;
        Double cash1=0.0;

        //System.out.println("CH:"+cash+" | PP:"+purchasePrice);

        if(purchasePrice > cash) {
            System.out.print("ERROR");
        }


        if(Math.abs(purchasePrice - cash) < EPSILON) {
            System.out.print("ZERO");
        }

        cash = Double.valueOf(df.format(cash - purchasePrice));

        //System.out.println("pp:"+purchasePrice+": ch :"+cash);

        while (cash > 0) {

            currency = currencyMap[i];

            if(cash < currency) {
                i++;
                continue;
            }

            cash  = Double.valueOf(df.format(cash % currency)); 

            cash1  = Double.valueOf(df.format(cash / currency)); 

            System.out.print(currencyName[i]);
            if(cash > 0) 
                System.out.print(",");
            //System.out.println("cash"+cash);
            //System.out.println("cash1:"+cash1);
        }
        System.out.println();
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                Double pp = Double.parseDouble(lineArray[0]);
                Double ch = Double.parseDouble(lineArray[1]);
                if (lineArray.length > 0) {
                    change(pp,ch);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

