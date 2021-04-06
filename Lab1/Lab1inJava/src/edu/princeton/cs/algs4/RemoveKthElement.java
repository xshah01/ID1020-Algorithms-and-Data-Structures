/*
  RemoveKthElement.java
  Created by Shadab Ahmed on 2020-09-07.
*/

package edu.princeton.cs.algs4;

class RemoveKthElement {

    static class Node {

        private Node next;
        private int data;

    }

    /*
      Method to insert a node in a linked list.
    */
    static Node create (Node head, int n) {

        Node ptr = head;

        Node temp = new Node();
        temp.data = n;
        temp.next = null;

        if (head == null) {
            head = temp;
        }

        else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }

        PrintList(head);

        return head;
    }

    /*
      Function to remove kth node from the end.
    */
    static Node RemoveKthFromEnd(Node head, int A) {

        int len = 0;
        Node tmp = head;

        /*
          Increment len to get length of the list.
        */
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        /*
          We cannot remove any nodes if the index is greater than len.
        */
        if (A > len) {

            System.out.print("The linked list consists of only: " + len + " elements.");
            System.out.println(" We therefore cannot remove " + A+ "th node from the list.");
            return head;

        }

        /*
          Remove the head node if the index equals to len.
        */
        else if (A == len) {

            System.out.println("Removing first element...");
            return head.next;

        }

        /*
          Remove the node on (len - index) from the start.
        */
        else {

            int diff = len - A;
            Node prev= null;
            Node curr = head;

            for(int i = 0; i < diff; i++) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;
            return head;

        }

    }

    /*
      This method prints the content of the linked list starting from the given node.
    */
    static void PrintList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node node = null;

        node = create(node, 2);
        node = create(node, 3);
        node = create(node, 4);
        node = create(node, 5);


        System.out.print("Linked list before adding or removing: \n");
        PrintList(node);

        node = RemoveKthFromEnd(node, 2);

        System.out.print("Linked list after modification: \n");
        PrintList(node);

    }

}