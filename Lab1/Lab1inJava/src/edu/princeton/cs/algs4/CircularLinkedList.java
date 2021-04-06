/*
  CircularLinkedList.java
  Created by Shadab Ahmed on 2020-09-06.
*/

package edu.princeton.cs.algs4;
import java.util.NoSuchElementException;

/*
  Below class uses a singly linked list for the queue.
*/

public class CircularLinkedList {

    private Node head;                                          // head of the list
    private Node tail;                                          // tail of tbe list

    /*
      Constructor to create and define
      a new node. The head and the tail of
      the list is initialized as empty (null).
    */
    private static class Node {

        private Node next;
        private final int data;

        private Node(int d) {
            this.data = d;
        }
    }

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /*
      addFirst() takes an integer and put it
      in the beginning of the list.
    */
    public void addFirst(int i) {

        Node newNode = new Node(i);                              // create our node

        if (head == null) {                                      // if the list is empty
            head = newNode;                                      // newNode will be our head
            tail = newNode;                                      // ... and our tail
            newNode.next = head;                                 // keep it circular

        } else {                                                 // if list is not empty
            newNode.next = head;
            head = newNode;
            tail.next = head;                                    // keep it circular
        }

        PrintList();

    }

    public void addLast(int i) {

        Node newNode = new Node(i);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;

        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        PrintList();

    }

    public void deleteHead() {

        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head == tail) {
            tail = null;

        } else {
            head = head.next;
            tail.next = head;
        }

        PrintList();

    }

    public void deleteTail() {

        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head != tail) {

            Node current = head;

            /*
              While-loop to find tail.
            */
            while (current.next != tail) {
                current = current.next;
            }

            {
                tail = current;
                tail.next.next = null;
                tail.next = head;
            }

            PrintList();

        }

    }

    /*
      This function prints the content of the
      linked list starting from the given node.
     */
    public void PrintList() {

        Node first = head;
        if (head == null) {
            System.out.println("No elements in the list");

        } else {
            do {
                System.out.print(first.data + "  ->  ");
                first = first.next;
            }

            while (first != head); {
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {


        CircularLinkedList CLL = new CircularLinkedList();

        CLL.addFirst(2);
        CLL.addFirst(1);
        CLL.addLast(3);
        CLL.addFirst(4);

        CLL.deleteHead();
        CLL.deleteTail();

    }

}