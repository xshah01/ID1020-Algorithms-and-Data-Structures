/*
  assignment6.java
  Created by Shadab Ahmed on 2020-09-19.

  Below class provides static methods for sorting an array using an optimized version of Merge Sort. The code is
  reused from edu.princeton.cs.algs4 (Robert Sedgewick and Kevin Wayne).

  This class implements improvements to cut the running time of Merge Sort with some modifications. It uses Insertion
  Sort for small subarrays, it constantly test whether array is already in order, and it eliminates the copy to
  the auxiliary array.
*/

import java.util.Comparator;
import java.util.Random;

public class assignment6 {

        private static final int CUTOFF = 10;                                       // cutoff to insertion sort

        private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

            // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
            assert isSorted(src, lo, mid);
            assert isSorted(src, mid+1, hi);

            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)              dst[k] = src[j++];
                else if (j > hi)               dst[k] = src[i++];
                else if (less(src[j], src[i])) dst[k] = src[j++];                    // to ensure stability
                else                           dst[k] = src[i++];
            }

            // postcondition: dst[lo .. hi] is sorted subarray
            assert isSorted(dst, lo, hi);
        }

        private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {

            /*
              Run insertionSort() as soon as the CUTOFF value is equal to the CUTOFF value + the lower index.
            */
            if (hi <= lo + CUTOFF) {
                insertionSort(dst, lo, hi);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(dst, src, lo, mid);
            sort(dst, src, mid+1, hi);



            // using System.arraycopy() is a bit faster than the above loop
            if (!less(src[mid+1], src[mid])) {
                System.arraycopy(src, lo, dst, lo, hi - lo + 1);
                return;
            }

            merge(src, dst, lo, mid, hi);
        }

        public static void sort(Comparable[] num) {
            Comparable[] aux = num.clone();
            sort(aux, num, 0, num.length-1);
            assert isSorted(num);
        }

        // sort from num[lo] to num[hi] using insertion sort
        private static void insertionSort(Comparable[] num, int lo, int hi) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && less(num[j], num[j-1]); j--)
                    exch(num, j, j-1);
        }

        // exchange num[i] and num[j]
        private static void exch(Object[] num, int i, int j) {
            Object swap = num[i];
            num[i] = num[j];
            num[j] = swap;
        }

        // is a[i] < a[j]?
        private static boolean less(Comparable a, Comparable b) {
            return a.compareTo(b) < 0;
        }

        // is a[i] < a[j]?
        private static boolean less(Object a, Object b, Comparator<Object> comparator) {
            return comparator.compare(a, b) < 0;
        }

        public static void sort(Object[] num, Comparator<Object> comparator) {
            Object[] aux = num.clone();
            sort(aux, num, 0, num.length-1, comparator);
            assert isSorted(num, comparator);
        }

        private static void merge(Object[] src, Object[] dst, int lo, int mid, int hi, Comparator<Object> comparator) {

            // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
            assert isSorted(src, lo, mid, comparator);
            assert isSorted(src, mid+1, hi, comparator);

            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)                          dst[k] = src[j++];
                else if (j > hi)                           dst[k] = src[i++];
                else if (less(src[j], src[i], comparator)) dst[k] = src[j++];
                else                                       dst[k] = src[i++];
            }

            // postcondition: dst[lo .. hi] is sorted subarray
            assert isSorted(dst, lo, hi, comparator);
        }


        private static void sort(Object[] src, Object[] dst, int lo, int hi, Comparator<Object> comparator) {
            // if (hi <= lo) return;
            if (hi <= lo + CUTOFF) {
                insertionSort(dst, lo, hi, comparator);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(dst, src, lo, mid, comparator);
            sort(dst, src, mid+1, hi, comparator);

            // using System.arraycopy() is a bit faster than the above loop
            if (!less(src[mid+1], src[mid], comparator)) {
                System.arraycopy(src, lo, dst, lo, hi - lo + 1);
                return;
            }

            merge(src, dst, lo, mid, hi, comparator);
        }

        // sort from a[lo] to a[hi] using insertion sort
        private static void insertionSort(Object[] a, int lo, int hi, Comparator<Object> comparator) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                    exch(a, j, j-1);
        }

        /***************************************************************************
         *  Check if array is sorted - useful for debugging.
         ***************************************************************************/
        private static boolean isSorted(Comparable[] a) {
            return isSorted(a, 0, a.length - 1);
        }

        private static boolean isSorted(Comparable[] num, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++)
                if (less(num[i], num[i-1])) return false;
            return true;
        }

        private static boolean isSorted(Object[] num, Comparator<Object> comparator) {
            return isSorted(num, 0, num.length - 1, comparator);
        }

        private static boolean isSorted(Object[] num, int lo, int hi, Comparator<Object> comparator) {
            for (int i = lo + 1; i <= hi; i++)
                if (less(num[i], num[i-1], comparator)) return false;
            return true;
        }

        /*
          Reads a sequence of numbers from the random generated array, and then mergesort them
          using a optimized version of mergesort().
        */
        public static void main(String[] args) {

            Random rand = new Random(1);
            String[] num = new String[1000000];

            for (int i = 0; i < num.length; i++) {
                num[i] = String.valueOf(rand.nextInt());
            }

            System.out.println();

            double start = System.nanoTime();
            assignment6.sort(num);
            double end = System.nanoTime();
            double time = (end - start)/1000000000;
            System.out.println("Elapsed Time with CUTOFF " + CUTOFF + ": " + time + " s");

        }

}