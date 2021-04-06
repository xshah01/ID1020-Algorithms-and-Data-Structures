/*
  assignment3.java
  Created by Shadab Ahmed on 2020-09-12.
  For each comparison, the principal of Insertion Sort is used in this assignment.

  The conditions for an inversion are following:

  a[i] > a[j] AND i < j

  For the inversion method, we let the first for loop start from array[0] and the second start from the following index.
  If the element in array[0] is greater than the following element, we know that the elements will swap as the
  conditions for an inversion is met.

  When we print the inversions, i and j represents the indices and array[i], array[j] represents the values of the
  elements respectively.
*/

public class assignment3 {

    public static void insertionSort(int[] array) {

        int counter = 0;

        for (int i = 1; i < array.length; i++) {

             /*
               Put the current element array[i] into tmp and compare it to its predecessor.
               If tmp is smaller than its predecessor, compare it to the elements before.
               Move the greater elements one position up to make space for the swapped element.
             */
            int tmp = array[i];
            int j = i-1;

            while (j >= 0 && array[j]>tmp) {

                array[j+1] = array[j];
                j--;
                array[j+1] = tmp;

                counter++;

                System.out.println(java.util.Arrays.toString(array));
                System.out.println("Number of swaps so far: " + counter);
                System.out.println();

            }

        }

        System.out.println("Total number of swaps: " + counter);

    }

    private static void inversionsCount(int[] array) {

        int inversions = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++)
                if (array[i] > array[j]) {
                    inversions++;
                    System.out.print("Inversion " + inversions + ": "
                            + "("+ "[" + i + "," + array[i] + "]" +","+ "[" + j + "," + array[j] + "]" +")" + "  ");
                }
        }

        System.out.println();
        System.out.println();
        System.out.println("Total number of inversions: " + inversions);
    }

    public static void main (String[] args) {

        int[] num = {1, 2, 4, 3, 5, 0};

        System.out.println();
        System.out.println("Unsorted array: " + java.util.Arrays.toString(num));
        System.out.println();
        inversionsCount(num);
        System.out.println();
        System.out.println("Now let us sort the array... ");
        System.out.println();
        insertionSort(num);
        System.out.println();
        System.out.println("Sorted array: "+ java.util.Arrays.toString(num));
    }

}