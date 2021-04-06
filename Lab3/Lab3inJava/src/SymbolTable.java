public class SymbolTable {

    public static class St<Key extends Comparable<Key>, Value> {

        private Key[] keys;
        private Value[] vals;
        private int N;

        /*
          keys[] will hold and use comparable.
          vals[] will hold and use any object.
        */
        public St(int capacity) {
            keys = (Key[]) new Comparable[capacity];
            vals = (Value[]) new Object[capacity];
        }

        public int size() {
            return N;
        }

        public int rank(Key key) {

            int low = 0;
            int high = N-1;
            while (low <= high) {
                int mid = low + (high - low) / 2;                                                                        // we use this to avoid overflow for big integers
                int comp = key.compareTo(keys[mid]);                                                                     // compare the given key to the key in the middle
                if      (comp < 0) high = mid - 1;                                                                       // if the the result is negative, new high will be the mid-1
                else if (comp > 0) low = mid + 1;                                                                        // otherwise go right and do the same thing
                else return mid;                                                                                         // if the key is the same value as mid, return mid
            }
            return low;                                                                                                  // return low if low is more than

        }

        /*
          Return the value associated with the given key in this symbol table.
          If the key is in the symbol table, return the value. Otherwise return null.
        */
        public Value get(Key key) {

            if (this.N == 0) {
                return null;
            }
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) {
                return vals[i];
            }
            else {
                return null;
            }

        }

        /*
          This method builds the table. It retrieves the index for the key with rank(). If the key already
          exists in the symbol table, it overwrites the value with the new value. If it is a unique key, it
          shifts the keys and and its associated values to the right, and  then stores the new key
          in the given index with its associated value.
        */
        public void put(Key key, Value val) {

            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) {
                vals[i] = val;
                return;
            }
            for (int j = N; j > i; j--) {
                keys[j] = keys[j-1]; vals[j] = vals[j-1];
            }
            keys[i] = key; vals[i] = val;
            N++;
        }

    }

    public void freq_count_st(String[] words) {

        St<String,Integer> st = new St<>(words.length);

        /*
          Build the symbol table and count frequencies.
        */
        int i =0;
        while (i<words.length) {

            String word = words[i];
            i++;

            if ( st.get(word) == null ) {                                                                                // if the key is not in the symbol table
                st.put(word, 1);                                                                                     // ... put the word into the symbol table
            }                                                                                                            // ... and a value of 1
            else {
                st.put(word, st.get(word) + 1);                                                                      // if the key already exists
            }                                                                                                            // ... increment the value

        }

        /*
          Find the key with the highest frequency count.
        */
        String MostFrequent = words[0];
        for (int k =1 ; k < words.length ; k++) {
            if (st.get(words[k])!= null && st.get(words[k]).compareTo(st.get(MostFrequent)) > 0) {
                MostFrequent = words[k];
            }

        }

        System.out.println("Most frequent word: " + "'" + MostFrequent + "'" + ", which is read " + st.get(MostFrequent) + " times.");
        System.out.println("Number of distinct words: " + st.size());
    }

}
