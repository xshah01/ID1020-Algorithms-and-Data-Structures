/*
  Graph.java

  This class represents an undirected graph of vertexes.
  It supports the following two primary operations: add an edge to the graph, iterate over all of the
  vertices adjacent to a vertex. It also provides methods for returning the degree of a vertex, the
  number of vertices V in the graph, and the number of edges E in the graph.

  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
*/

package edu.princeton.cs.algs4;
import java.util.NoSuchElementException;

public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /*
      Initializes an empty graph with V vertices and 0 edges.
    */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /*
      Initializes a graph from the specified input stream. The format is the number of vertices,
      followed by the number of edges, followed by pairs of vertices, with each entry
      separated by whitespace.
    */
    public Graph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    /*
      Initializes a new graph that is a deep copy of G.
    */
    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /*
      Returns the number of vertices in this graph.
    */
    public int V() {
        return V;
    }

    /*
      Returns the number of edges in this graph.
    */
    public int E() {
        return E;
    }

    /*
      throw an IllegalArgumentException unless {@code 0 <= v < V}
    */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /*
      Adds the undirected edge v-w to this graph.
    */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /*
     Returns the vertices adjacent to vertex v.
    */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

}
