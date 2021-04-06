/*
  assignment1.java
  Created by Shadab Ahmed on 2020-09-12.

  In this assignment, Insertion Sort is used to sort and print the content
  of an array defined by the user in main().

  We start by comparing the value of array[1] with array[0]. If index 1 is less than index 0, we swap them.
  Then, we make the third element (array[2]) compare it with elements to its left and insert it at the right position.
  We go on repeating this, until the array is sorted.
*/

public class assignment1 {

     public static void insertionSort(int[] array) {

         for (int i = 1; i < array.length; i++) {

             /*
               Put the current element array[i] into tmp and compare it to its predecessor.
               If tmp is smaller than its predecessor, compare it to the elements before.
               Move the greater elements one position up to make space for the swapped element.
             */
             int tmp = array[i];
             int j = i-1;

             while (j >= 0 && array[j]>tmp) {

                 array[j + 1] = array[j];
                 j--;
                 array[j+1] = tmp;

                 System.out.println(java.util.Arrays.toString(array));
                 System.out.println();

             }

         }

     }

         public static void main (String[] args) {

             int[] num = {1, 2, 4, 3, 5, 0};

             System.out.println();
             System.out.println("Unsorted array: " + java.util.Arrays.toString(num));
             System.out.println();
             insertionSort(num);
             System.out.println();
             System.out.println("Sorted array: "+ java.util.Arrays.toString(num));
         }

 }