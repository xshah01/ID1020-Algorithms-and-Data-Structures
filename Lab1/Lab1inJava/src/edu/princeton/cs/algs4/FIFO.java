/*
  FIFO.java
  Created by Shadab Ahmed on 2020-09-05.
*/

package edu.princeton.cs.algs4;
import java.util.NoSuchElementException;

/*
  Below class uses a doubly linked circular list for the FIFO-based queue.
*/

public class FIFO {

    private Node head;                                                            // beginning of the queue
    private Node tail;                                                            // end of the queue
    private int n;                                                                // number of elements on the queue

    public static class Node {

        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    public int size() {
        return n;
    }

    /*
      Add element to the list in FIFO-order.
    */
    public void addNode(int data) {

        Node node = new Node(data);

        if(head==null) {

            head = node;
            tail = node;
            head.next = head;
            head.previous = tail;

        }

        else {

            tail = head;

            while(tail.next!=head) {
                tail = tail.next;
            }

                tail.next = node;
                node.next = head;
                node.previous = tail;
                head.previous = node;

        }
        n++;
    }

    /*
      Remove element from the list in FIFO-order (end of the list).
    */
    public void deleteNode() {

        if (head == null) {
            throw new NoSuchElementException("Queue underflow");
        }
        else if (size()==1) {
            head.next = null;
            head.previous = null;
            head = null;
        }

        else {
            tail = head;
            head.next.previous = head.previous;
            head.previous.next = head.next;
            head = head.next;
        }
        n--;
    }

    public void add(FIFO enqueue, int data) {
        enqueue.addNode(data);
        enqueue.PrintList();
        System.out.println();
    }

    public void remove(FIFO dequeue) {
        dequeue.deleteNode();
        dequeue.PrintList();
        System.out.println();
    }

    /*
      Function to print the content of the linked list.
    */
    public void PrintList() {

        tail = head;

        do {

            System.out.print(tail.data + "  -  " );

            tail = tail.next;

        }

        while(tail!=head);

    }

    public static void main(String[] args) {

        FIFO list = new FIFO();

        System.out.println("FIFO queue: ");

        list.add(list,1);
        list.add(list,2);
        list.add(list, 3);
        list.add(list, 4);
        list.remove(list);
        list.remove(list);

    }

}