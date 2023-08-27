import java.util.Random;

public class QuickSort {

    private static int M = 15;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        if (hi <= lo + M) { 
            for (int g = lo + 1; g < hi; g++) {
                for(int k = g; k > 0 && less(a[k], a[k - 1]); k--) {
                    exch(a, k, k - 1);
                }
            }
        }
        int j = partition(a, lo, hi);  // Partition (see page 291).
        sort(a, lo, j-1);              // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); 

    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            } 
        } return true;
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        Random random = new Random();
        Integer[] arr = new Integer[1000000];
        stopwatch.start();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = random.nextInt(400000);
        }
        stopwatch.stop();
        long elapsedTime = stopwatch.getElapsedTime();
        System.out.println("Elapsed Time giving random values: " + (elapsedTime / 1_000_000) + " ms");
        System.out.println("starting to sort");
        stopwatch.reset();
        stopwatch.start();
        sort(arr);
        stopwatch.stop();
        elapsedTime = stopwatch.getElapsedTime();
        System.out.println("Elapsed Time sorting: " + (elapsedTime / 1_000_000) + " ms");
        System.out.println("sorting finished, snip: " + arr[1] +" " +arr[2]+ " " +arr[3] + " " + arr[4] + " " + arr[5]+ " " + arr[6]);
        System.out.println(isSorted(arr));
    }
}
