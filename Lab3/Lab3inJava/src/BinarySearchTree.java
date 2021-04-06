public class BinarySearchTree {

    public static class Bst<Key extends Comparable<Key>, Value> {

        public Node root;

        private class Node {

            private Key key;
            private Value val;
            private Node left, right;
            private int N;

            public Node(Key key, Value val, int N) {
                this.key = key;
                this.val = val;
                this.N = N;
            }

        }

        public int size() {
            return size(root);
        }
        private int size(Node n) {
            if (n == null) {
                return 0;
            }
            else {
                return n.N;
            }
        }

        /*
          Return the associated value with the key in the subtree rooted at n.
          Return null if the key not present in subtree rooted at n.
        */
        public Value get(Node n, Key key) {

            if (n == null) {
                return null;
            }
            int cmp = key.compareTo(n.key);
            if (cmp < 0) {
                return get(n.left, key);
            }
            else if (cmp > 0) {
                return get(n.right, key);
            }
            else {
                return n.val;
            }

        }

        public Value get(Key key) {
            return get(root, key);
        }

        /*
          Change key’s value to val if the key already exists in subtree rooted at n.
          Otherwise, add new node to subtree associating key with val.
        */
        public Node put(Node n, Key key, Value val) {

            if (n == null) {                                                                                             // insert new node if tree is empty
                return new Node(key, val, 1);
            }
            int cmp = key.compareTo(n.key);                                                                              // compare the given key to the root's key

            if (cmp < 0) {                                                                                               // go left if the key is less than root, send the next node to put
                n.left  = put(n.left,  key, val);
            }
            else if (cmp > 0) {                                                                                          // otherwise go right and do the same thing
                n.right = put(n.right, key, val);
            }
            else {                                                                                                       // replace the root's key with the given key if it already exists
                n.val = val;
            }
            n.N = size(n.left) + size(n.right) + 1;                                                                      // increment the size of tree

            return n;
        }

        /*
          Search for the key, update the value if it exists.
          Grow table if it is unique.
        */
        public void put(Key key, Value val) {
            root = put(root, key, val);
        }

    }

    public void freq_count_bst(String[] words) {

        Bst<String,Integer> bst = new Bst<String,Integer>();

        /*
          Build the symbol table and count frequencies.
        */
        int i =0;
        while (i<words.length) {

            String word = words[i];
            i++;

            if (null == bst.get(word)) {
                bst.put(word, 1);
            }
            else {
                bst.put(word, bst.get(word) + 1);
            }

        }

        /*
          Find the key with the highest frequency count.
        */
        String MostFrequent = words[0];

        for (int k =1 ; k < words.length ; k++) {
            if (null != bst.get(words[k]) && bst.get(words[k]).compareTo(bst.get(MostFrequent)) > 0) {
                MostFrequent = words[k];
            }
        }
        System.out.println("Most frequent word: " + "'" + MostFrequent + "'" + ", which is read " + bst.get(MostFrequent) + " times.");
        System.out.println("Number of distinct words: " + bst.size());
    }

}