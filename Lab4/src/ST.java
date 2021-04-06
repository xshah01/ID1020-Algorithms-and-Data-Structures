/*
  ST.java

  This class represents an ordered symbol table of generic key-value pairs.
  A symbol table implements the <em>associative array</em> abstraction:
  when associating a value with a key that is already in the symbol table,
  the convention is to replace the old value with the new value.

  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
*/

package edu.princeton.cs.algs4;
import java.util.Iterator;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /*
      Initializes an empty symbol table.
    */
    public ST() {
        st = new TreeMap<Key, Value>();
    }

    /*
      Returns the value associated with the given key in this symbol table.
    */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    /*
     Inserts the specified key-value pair into the symbol table, overwriting the old
     value with the new value if the symbol table already contains the specified key.
     Deletes the specified key (and its associated value) from this symbol table
     if the specified value is null.
    */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /*
      Removes the specified key and its associated value from this symbol table
      (if the key is in this symbol table).
    */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    /*
      Removes the specified key and its associated value from this symbol table
      (if the key is in this symbol table).
    */
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        st.remove(key);
    }

    /*
      Returns true if this symbol table contain the given key, false otherwise.
    */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    /*
      Returns the number of key-value pairs in this symbol table.
    */
    public int size() {
        return st.size();
    }

    /*
      Return true if this symbol table is empty, false otherwise.
    */
    public boolean isEmpty() {
        return size() == 0;
    }

    /*
      Returns all keys in this symbol table.
    */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /*
      Return all of the keys in this symbol table.
      Return an iterator to all of the keys in this symbol table
     */
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

}