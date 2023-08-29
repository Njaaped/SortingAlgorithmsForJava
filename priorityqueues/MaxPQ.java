
/*
 * finding priority queues
 * parent = floor(index / 2)
 * children = (2*index) and (2*index) + 1
 * 
 * d = {
 *  0: none
 *  1: 9
 *  2: 8
 *  3: 5
 *  4: 7
 *  5: 2
 *  6: 3
 *  7: 4
 *  8: 1
 *  9: 6
 * }
 * 
 * example = parent of index 9:
 *           floor(9 / 2) = index 4
 *           Right child of index 3:
 *           (2*3) + 1 = 7 
 */




public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

}





