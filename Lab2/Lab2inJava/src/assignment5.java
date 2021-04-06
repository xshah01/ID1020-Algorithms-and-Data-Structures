/*
  assignment5.java
  Created by Shadab Ahmed on 2020-09-16.

  In this assignment, execution times are estimated for sorting arrays of integers with Insertion Sort and Merge Sort.
  The sorting algorithms are invoked from edu.princeton.cs.algs4 (Robert Sedgewick and Kevin Wayne).

  In order to reuse the same random array that was generated, the random numbers are given "seed" to maintain the same
  sequence of numbers. Since the same sequence is generated each time, the seed remains the same.

  The test of each sorting algorithm can therefore be implemented in the main function with the same random array, and
  more importantly, without interfering each other's sorting.
*/

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;

import java.util.Random;

public class assignment5 {

    public static void main (String[] args) {

        System.out.println();

        /*
          Initialize an array of fixed length. Thereafter, create two random number generator
          with the same seed value in order to reuse the same random array.
        */
        String[] num = new String[5000];
        Random rand1 = new Random(1);
        Random rand2 = new Random(1);

        /*
          Place the random integers into the array.
        */
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(rand1.nextInt());
        }

        double MergeStart = System.nanoTime();
        Merge.sort(num);
        double MergeEnd = System.nanoTime();
        double MergeTime = (MergeEnd - MergeStart)/1000000000;
        System.out.println("Merge Sort Elapsed Time: " + MergeTime);

        System.out.println();

        /*
          Place the same random integers into the array.
        */
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(rand2.nextInt());
        }

        double InsertionStart = System.nanoTime();
        Insertion.sort(num);
        double InsertionEnd = System.nanoTime();
        double InsertionTime = (InsertionEnd - InsertionStart)/1000000000;
        System.out.println("Insertion Sort Elapsed Time: " + InsertionTime);

    }

}