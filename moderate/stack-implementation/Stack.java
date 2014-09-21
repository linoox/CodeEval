import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.NoSuchElementException;

    // sol pretty much from - http://algs4.cs.princeton.edu/13stacks/Stack.java.html
    // was reading this when i came across this question
    // used this code as it was a good way to learn writing apis
public class Main {

private static class Stack {
    private int stackSize;
    private Node first;

    private static class Node {
        private int item;
        private Node next;
    }

    public Stack() {
        first = null;
        stackSize=0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(int num) {
        Node oldFirst = first;
        first = new Node();
        first.item = num;
        first.next = oldFirst;
        stackSize++;
    }

    public int pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");   
        int item = first.item;
        first = first.next;
        stackSize--;
        return item;
    }

    public int size() {
        return stackSize;
    }

}
    public static void main (String[] args) {

        Stack stack = new Stack();
        int len=0;

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                len = lineArray.length;
                if (lineArray.length > 0) {
                    for (int i=0;i<len;i++) {
                        stack.push(Integer.parseInt(lineArray[i]));   
                    }

                    // output
                    for (int j=0;j<len;j++) {

                        if(j%2==0) {
                            if(j>=1 ) System.out.print(" ");
                            System.out.print(stack.pop());
                        } else {
                            stack.pop();
                        }
                    }
                    
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
        

    }
}

