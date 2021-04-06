/*
  iteration.java
  Created by Shadab Ahmed on 2020-09-04.
*/

package edu.princeton.cs.algs4;

/*
  Below method creates a reversed string representation of characters
  read from StdIn by using iteration. Code is reused from edu.princeton.cs.algs4
  (Robert Sedgewick and Kevin Wayne).
 */

public class iteration {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        while (!StdIn.isEmpty()) {                                      // as long as the text file is not empty
            stack.push(StdIn.readChar());                               // the characters are pushed onto the stack
        }

        System.out.println("Reversed string: ");

        for (char i : stack) {                                          // for each character on the stack
            StdOut.print(i);                                            // ... the characters are printed to StdOut

        }

        System.out.println();
    }

}