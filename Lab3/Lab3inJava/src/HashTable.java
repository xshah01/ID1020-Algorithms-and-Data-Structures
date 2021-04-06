/*
  Assignment 3
  HashTable.java
  Created by Shadab Ahmed on 2020-09-26.

  In this assignment, the built-in java implementation hashCode() is used to calculate a hash value for every key.
  It uses the Horner's method which takes the ASCII value of each character and, with below function, calculates a
  hash value to the key.

  s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

  , where n is the length of the string. By masking the hash value, it turn any signed 32-bit int to a 31-bit
  non-negative int. It then calculates with a modular value in order to create a distribution of an evenly
  built hash map with less collisions and better performance.

  The main purpose of hash operation is to make the hashcode differences visible in the least significant
  bits so that the hashmap elements can be distributed evenly across the buckets.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class HashTable {

    public static void main(String[]args) throws FileNotFoundException{

        /*
          Use HashMap to store the keys.
        */
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        Scanner file = new Scanner(new File("/Users/shadabahmed/Desktop/test.txt"));

        int WordCounter = 0;
        int WordFrequency = 0;
        int M = 138883;                                                                                                  // prime number to calculate modulo.

        while (file.hasNext()) {

            String key = file.next();

            if (map.containsKey(key)) {                                                                                  // if the key is already in the map
                WordFrequency++;                                                                                         // ... update the frequency of the word
            }


            map.put(key, (key.hashCode() & 0x7fffffff) % M);                                                             // put the key in the map, with its

                                                                                                                         // ... calculated hash code value
            System.out.println("Key: " + key);
            System.out.println("Hash code: " + (map.get(key)));
            System.out.println();
            WordCounter++;

        }

        file.close();

        System.out.println("Number of words in the text = " + WordCounter);
        System.out.println("Number of equal words in the text = " + WordFrequency);
        System.out.println("Number of keys in the Hashmap (distinct words in the text) = " + map.size());

    }

}