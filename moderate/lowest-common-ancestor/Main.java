import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    //todo: too less score on codeeval :(
    // seems this has v high memory usage

    private Node root;

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    

    public static int lowestCommonAncestor(Node node, int key1, int key2) {            

        int lca = -1;
        
        if (node == null) {
            return lca;
        }

        while (node != null) {

            if (node.data > key1 && node.data > key2) {
                node = node.left;
            } else if (node.data < key1 && node.data < key2) {
                node = node.right;
            } else if (node.data == key1 || node.data == key2){
                return node.data;
            } else {
                return node.data;
            }
        }
        
        return lca;
        
    }


    public static void main (String[] args) {        

        Node root = new Node(30);
        Node n1 = new Node(8);
        Node n2 = new Node(52); 
        Node n3 = new Node(3);
        Node n4 = new Node(20);
        Node n5 = new Node(10);
        Node n6 = new Node(29);
            
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right=n6;
    

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (line.length() > 0) {
                    
                    System.out.println(lowestCommonAncestor(root, Integer.parseInt(lineArray[0]),Integer.parseInt(lineArray[1])));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}