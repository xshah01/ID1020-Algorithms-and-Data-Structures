/*
  OrderedQueue.java
  Created by Shadab Ahmed on 2020-09-08.
*/

package edu.princeton.cs.algs4;
import java.util.NoSuchElementException;
import java.lang.*;


public class OrderedQueue<Value> {

    private Node head;                                              // beginning of queue
    private Node tail;                                              // end of queue
    private int n;                                                  // number of elements on queue


    private static class Node {
        private Node next;
        private Node prev;
        private int x;
    }

    /*
      Initialize an empty queue.
    */
    public OrderedQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void add( int value){
        enqueue(value);
        PrintList();
    }

    /*
      Method for adding item to the queue.
    */
    private void enqueue(int i) {

        Node newNode = new Node();

        /*
          Checks if the list is empty.
        */
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            head.x = i;
            head.next = head;
            head.prev = head;
        }

        /*
          Checks if the data value of the newNode is
          less than this value.
        */
        else if(i<head.x) {
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
            newNode.x = i;
            head=newNode;
        }

        else {

            tail = head;

            /*
              Checks if the data value of the newNode is
              larger or equals to this value.
             */
            while(i >= tail.x) {
                tail = tail.next;
                if(tail == head)break;
            }
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            newNode.x = i;
        }

        tail = head;
        n++;
    }

    public void remove() {
        dequeue();
        PrintList();
    }

    private void dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        if (size()==1) {
            tail.next=null;
            tail.prev=null;
            tail = null;
        }

        else {
            tail = head;
            tail.next.prev= tail.prev;
            tail.prev.next= tail.next;
            tail = tail.next;
            head = tail;
        }
        n--;
    }

    public void PrintList() {

        if(isEmpty()) {
            System.out.print("List is empty");
        }
        else if(size()==1) {
            System.out.print(tail.x + " - ");
        }
        else {
            tail = head;
            do {
                System.out.print(tail.x + " - ");
                tail = tail.next;
            }
            while (tail != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        OrderedQueue<String> queue = new OrderedQueue<>();

        queue.add(5);
        queue.add(2);
        queue.remove();
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.add(1);

    }
}