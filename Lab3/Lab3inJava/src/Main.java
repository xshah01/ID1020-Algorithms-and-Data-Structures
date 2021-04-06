/*
  Assignment 2
  Main.java
  Created by Shadab Ahmed on 2020-09-24.

  Unit test to analyse the running time for building an Ordered Array ST in contrast to Binary Search Tree.
  This class invokes both SymbolTable.java and BinarySearchTree.java by calling the Frequency Counter method
  in each classes respectively.

  The data structures of Ordered Array ST and Binary Search Tree are reused and modified from edu.princeton.cs.algs4
  (Robert Sedgewick and Kevin Wayne).
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[]args) throws Exception {

        System.out.println();

        File file = new File ("/Users/shadabahmed/Desktop/test.txt");
        Scanner input = new Scanner(file);
        Scanner userInput = new Scanner(System.in);

        System.out.print("Number of words to read: ");
        int N = userInput.nextInt();
        String [] words = new String[N];

        System.out.println();

        /*
          Store all words in words[].
        */
        int i = 0;
        while(i < words.length && input.hasNext()) {
            String data = input.next();
            words[i] = data;
            i++;
        }

        SymbolTable st = new SymbolTable();
        BinarySearchTree bst = new BinarySearchTree();

        long start1 = System.nanoTime();
        st.freq_count_st(words);
        long stop1 = System.nanoTime();
        System.out.println("Runtime for SymbolTable = "+ (stop1-start1)/1000000 + " ms");

        System.out.println();

        long start2 = System.nanoTime();
        bst.freq_count_bst(words);
        long stop2 = System.nanoTime();
        System.out.println("Runtime for Binary Search Tree = " + (stop2-start2)/1000000 +" ms");


    }

}