/*
  Stack.java

  This class represents a last-in-first-out (LIFO) stack of generic items. It supports the usual
  push and pop operations, along with methods for peeking at the first item, testing if the
  queue is empty, and iterating through the items in LIFO order. This implementation uses a singly
  linked list with a static nested class for linked-list nodes.

  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
*/

package edu.princeton.cs.algs4;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>  {
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /*
      Initializes an empty stack.
    */
    public Stack() {
        first = null;
        n = 0;
    }

    /*
      Returns true if this stack is empty.
    */
    public boolean isEmpty() {
        return first == null;
    }

    /*
      Adds the item to this stack.
    */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /*
      Removes and returns the item most recently added to this stack.
    */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    /*
      Returns an iterator to this stack that iterates through the items in LIFO order.
    */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
