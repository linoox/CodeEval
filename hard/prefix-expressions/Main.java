import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.EmptyStackException;

public class Main {

    static int evaluatePrefixExpression(String[] exp) {
        double result = 0;
        double x=0;
        double y=0;
        int strlen = exp.length;
        Stack<Double> operandStack = new Stack<Double>();

        try {
            for (int i=strlen-1;i>=0;i--) {
                if (exp[i].equals("+")) {
                    x = operandStack.pop();
                    y = operandStack.pop();
                    result = x + y;
                    operandStack.push(result);
                } else if (exp[i].equals("*")) {
                    x = operandStack.pop();
                    y = operandStack.pop();
                    result = x * y;
                    operandStack.push(result);
                } else if (exp[i].equals("/")) {
                    x = operandStack.pop();
                    y = operandStack.pop();
                    result = x / y;
                    operandStack.push(result);
                } else {
                    operandStack.push(Double.parseDouble(exp[i]));
                }
            }
        } catch (EmptyStackException ese) {
            throw new IllegalArgumentException("Less than required number of arguments");
        }
        
        return (operandStack.pop().intValue());
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    System.out.println(evaluatePrefixExpression(lineArray));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

