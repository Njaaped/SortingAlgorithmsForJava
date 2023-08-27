import java.util.Random;

public class SelectionSort {
    public static void sort(Comparable[] a) {
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
        Integer[] arr = new Integer[200000];
        stopwatch.start();
        for (int i = 0; i < 200000; i++) {
            arr[i] = random.nextInt(200000);
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
