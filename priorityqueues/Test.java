
import java.util.Random;


public class Test {
    private static int M = 15;

    public static void quickSort(Comparable[] a) {
    
    int hi = a.length - 1;
    int lo = 0;

    sort(a, lo, hi);
    }


    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        if (hi <= lo + M) { 
            for (int g = lo + 1; g < hi; g++) {
                for(int k = g; k > 0 && less(a[k], a[k - 1]); k--) {
                    exch(a, k, k - 1);
                }
            }
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while(true) {
            while(less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while(less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable i, Comparable j) {
        return (i.compareTo(j) < 0);
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            } 
        } return true;
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        Random random = new Random();
        int k = 1000000; //amount of random number we wil be assesing
        Integer[] quicksortlist = new Integer[k];
        MaxPQ<Integer> pqlist = new MaxPQ<>(k);
        Integer[] sortedpqlist = new Integer[k];
        System.out.println("starting quick list assess integers + sort the list... ");
        
        stopwatch.start();
        for (int i = 0; i < k; i++) {
            quicksortlist[i] = random.nextInt(k*10);
        }
        quickSort(quicksortlist);
        stopwatch.stop();
        long timeElapsed = stopwatch.getElapsedTime();
        stopwatch.reset();
        System.out.println("Quicksortlist is sorted: " + isSorted(quicksortlist) + " with the time usage: " + timeElapsed / 1_000_000 + " ms");
        stopwatch.start();
        for (int i = 0; i < k; i++) {
            pqlist.insert(random.nextInt(k));
        }
        for (int i = k - 1; i >= 0; i--) {
            sortedpqlist[i] = pqlist.delMax();
        }
        stopwatch.stop();
        timeElapsed = stopwatch.getElapsedTime();
        stopwatch.reset();
        System.out.println("PriorityQuesortlist is sorted: " + isSorted(sortedpqlist) + " with the time usage: " + timeElapsed / 1_000_000 + " ms");



    }
    
}







