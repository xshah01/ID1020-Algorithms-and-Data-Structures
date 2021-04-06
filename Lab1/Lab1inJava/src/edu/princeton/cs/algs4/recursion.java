/*
  recursion.java
  Created by Shadab Ahmed on 2020-09-05.
*/

package edu.princeton.cs.algs4;

/*
  Below method uses recursion to create a reversed string representation
  of characters read from StdIn.
 */

public class recursion {

    public static void reversedString(){
        Stack<Character> Stack = new Stack<Character>();
        char c = StdIn.readChar();                             // reads character from StdIn
        if (!StdIn.isEmpty()){
            Stack.push(c);                                     // pushes the character onto the stack
            reversedString();                                  // the function reversedString() is called again
        }
        StdOut.print(c);                                       // print the characters from the stack
    }

    public static void main (String[] args) {

        System.out.println("Reversed string: ");
        reversedString();                                      // the function reversedString() is called
        System.out.println();

    }

}