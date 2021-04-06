/*
  Queue.java

  This class represents a first-in-first-out (FIFO) queue of generic items. It supports the usual
  enqueue and dequeue operations, along with methods for peeking at the first item, testing if the
  queue is empty, and iterating through the items in FIFO order. This implementation uses a singly
  linked list with a static nested class for linked-list nodes.

  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
*/

package edu.princeton.cs.algs4;
import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /*
      Initializes an empty queue.
    */
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /*
      Returns true if this queue is empty.
    */
    public boolean isEmpty() {
        return first == null;
    }

    /*
      Adds the item to this queue.
    */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    /*
      Removes and returns the item on this queue that was least recently added.
    */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

}