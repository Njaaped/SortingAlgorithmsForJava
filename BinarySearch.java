

import java.util.Random;
import java.util.Scanner;


public class BinarySearch {

    public static boolean search(Comparable[] a, Comparable item) {
        int hi = a.length - 1;
        int lo = 0;
        boolean result = search(a, item, lo, hi);
        return result;

    }

    private static boolean search(Comparable[] a, Comparable item, int lo, int hi) {
        if (lo > hi) {
            return false;
        }
        int middle = lo + (hi - lo) / 2;
        int comparison = item.compareTo(a[middle]);
        if (comparison == 0) {
            return true; // item found
        } else if (comparison < 0) {
            return search(a, item, lo, middle - 1);
        } else {
            return search(a, item, middle + 1, hi);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] lis = new Integer[40000000];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 40000000; i++) {
            lis[i] = random.nextInt(40000000*4);
        }

        QuickSort.sort(lis);

        for (int i = 20000000; i < 20000000 + 15; i++) {
            System.out.println("num: " + lis[i]);
        }


        int num;
        

        while (true) {
            String newguess = "nothing";
            System.out.print("guess num: ");
            num = (int) scan.nextInt();
            boolean isthere = BinarySearch.search(lis, num);
            System.out.println("\nthe number " + num + " is " + isthere);
            while (true) {
                System.out.print("guess again? (y/n): ");
                newguess = scan.nextLine();
                if (newguess.equals("y") || newguess.equals("n")) {
                    break;
                }
            }
            if (newguess.equals("n")) {
                break;
            }
        }

    }
}
