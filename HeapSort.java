
import java.util.Random;




public class HeapSort {
    private static int M = 15;

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        System.out.println("heapsorted");
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
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

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < (N - 1) && less(a[j], a[j+1])) {
                j++;
            }
            if (!less(a[k], a[j])) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
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
