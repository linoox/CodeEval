import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;

public class Main {

    static boolean validParentheses(String str) {
        Stack<Character> parenStack = new Stack<Character>();

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            switch(ch) {
            case '(':parenStack.push(ch);
                     break;

            case ')':if(!parenStack.isEmpty()) {
                            if(parenStack.peek() == '(') 
                                parenStack.pop();
                      } else {
                            return false;
                      }          
                     break;

            case '[':parenStack.push(ch);
                     break;
            case ']': if(!parenStack.isEmpty()) {
                        if(parenStack.peek() == '[') {
                            parenStack.pop();
                        } 
                      } else {
                            return false;
                      } 
                     break; 
            case '{': parenStack.push(ch);
                      break;
            case '}':  if(!parenStack.isEmpty()) { 
                         if(parenStack.peek() == '{') {
                             parenStack.pop();
                         } 
                        } else {
                            return false;
                        }
                      break;    
            }

        }

        return parenStack.isEmpty();

    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    if(validParentheses(line)) {
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

