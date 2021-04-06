/*
  Part 1: Undirected graphs
  Assignment 2
  BFSPath.java
  This class uses implementations from edu.princeton.cs.algs
  (Robert Sedgewick and Kevin Wayne).
  Created by Shadab Ahmed on 2020-10-04.
*/

package edu.princeton.cs.algs4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BFSPath {

    private final boolean[] marked;		                                                                                 // marked[v] = is there an s-v path?
    private final int[] edgeTo;			                                                                                 // last vertex (on known path) to this vertex
    private final int source;		                                                                                     // source

    /*
      DFSPath computes a path between the source vertex s and every other vertex in the graph G.
    */
    public BFSPath(Graph G, int s) {

        marked = new boolean[G.V()];		                                                                             // mark this vertex as visited (true). marked is an array consisting every visited vertex with the size of every vertex in the graph.
        edgeTo = new int[G.V()];			                                                                             // which is the last vertex before this vertex? edgeTo is an array consisting different integers connected to indices.
        this.source = s;					                                                                             // take an input for source
        bfs(G,s);                                                                                                        // do dfs() traversing

    }

    /*
      Breadth first search uses a queue to store all the unmarked vertexes starting from the source vertex.
      The vertex is processed by checking all the adjacent vertexes (random pick since Graph uses Bag). For all
      unmarked vertexes, add them to the queue to process them later. Ignore all the marked vertexes. After
      processing the vertex, take the next vertex from the queue and start process it. All vertexes adjacent
      to that vertex, if not marked, add it to the queue, mark it, and remember the edge to that vertex.
    */
    private void bfs(Graph G, int s) {

        Queue<Integer> queue = new Queue<>();

            queue.enqueue(s);
            marked[s] = true;

        while (!queue.isEmpty()) {

            int v = queue.dequeue();

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }

        }

    }

    /*
      Is there a path between the source vertex s and the vertex v?
      Return true if there is a path, false otherwise.
    */
    private boolean hasPathTo(int v) {
        return marked[v];
    }

    /*
      Return a path between source vertex s and vertex v, or null if no such path exists.
      pathTo returns the sequence of vertices on a path between the source vertex s and vertex v.
      Starting from the destination vertex, iterate to the previous vertexes after finding the edge
      between the vertexes and then pushing the vertex to the stack.
    */
    private Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;

    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/shadabahmed/Desktop/graph.txt");
        Scanner sc = new Scanner(file);

        System.out.println();
        String key;
        int vertex = 0;

        /*
          Use Symbol Table for associating values with keys. table1 is to map from
          strings to integers, and table2 is to map from integers to strings.
        */
        ST<String, Integer> table1 = new ST<>();                                                                         // a symbol table with String keys (vertex names) and int values (indices) for indexing every vertexes (string -> index)
        ST<Integer, String> table2 = new ST<>();                                                                         // symbol table that serves as an inverted index, giving the index with to the associated vertex's name (index -> string)

        /*
          Initialize two stacks to push keys into.
        */
        Stack<String> stk1 = new Stack<>();
        Stack<String> stk2 = new Stack<>();

        /*
          If the key is not in the first ST, put it there alongside its indices (starting from vertex = 0), and then
          store the same vertex alongside the same key in the second ST. Push the key into the stack, and do the same
          procedure to the next key. Push the keys into the stack to later add edges between the them.
        */
        while(sc.hasNext()) {

            key = sc.next();
            if(table1.get(key) == null) {
                table1.put(key, vertex);
                table2.put(vertex, key);
                vertex++;
            }

            stk1.push(key);

            key = sc.next();
            if(table1.get(key) == null) {
                table1.put(key, vertex);
                table2.put(vertex, key);
                vertex++;
            }

            stk2.push(key);

        }

        sc.close();

        /*
          Create a graph of vertexes and add edges between the keys (v - w).
        */
        Graph G = new Graph(vertex);

        /*
          Add edges between the keys by popping them from the stack. addEdge() takes integers as parameter, and since
          it pops strings from the stack, get the values (indices) of the keys from table1 as it maps from strings
          to integers.
        */
        while(!stk1.isEmpty() && !stk2.isEmpty()) {
            G.addEdge(table1.get(stk1.pop()), table1.get(stk2.pop()));
        }

        System.out.print("Enter source: ");
        Scanner sc2 = new Scanner(System.in);
        String X = sc2.next().toUpperCase();

        System.out.print("Enter destination: ");
        Scanner sc3 = new Scanner(System.in);
        String Y = sc3.next().toUpperCase();

        sc2.close();
        sc3.close();

        BFSPath bfp = new BFSPath(G, table1.get(X));
        System.out.println();

        /*
          For every index of the stack returned from pathTo, store the key associated with that
          index using a string builder in str.
        */
        StringBuilder str = new StringBuilder();
        for (int i : bfp.pathTo(table1.get(Y))) {
            str.append(table2.get(i)).append(" -> ");
        }

        System.out.print("A path between " + X + " and " + Y + ": " + str);
        System.out.println();

    }

}