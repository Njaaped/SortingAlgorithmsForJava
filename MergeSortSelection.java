import java.util.Random;


/*
 * merge sort implemented with selection sort when the merge array
 * has gone down to 15 elements, also a test if the array is already sorted
 * before being called on merge, saves a litte bit of time.
 */

public class MergeSortSelection {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];    // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (a.length > 15) {
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
        } else {
            for (int i = 0; i < a.length; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (less(a[j], a[min])) {
                        min = j;
                    }
                }
                if (min != 1) {
                    exch(a, i, min);
                }
            }
        }
        if (!less(a[mid], a[mid+1])) {
            merge(a, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
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
