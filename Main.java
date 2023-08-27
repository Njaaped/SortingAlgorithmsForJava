
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        String bubble, insertion, selection, shell, merge, mergeSelection, quick;
        bubble = insertion = selection = shell = merge = mergeSelection = quick = "y";
        List<Integer> skip = new ArrayList<Integer>();
        String line;

        System.out.println("This is my program which will excecute the same \n random generated list and test the different sorting method which exists \n if you want a very long list i would suggest that \n you won't try Bubble sort, Insertion Sort or Selection Sort \n Since they are really slow on sorting big arrays.");
        System.out.println("Do you want to test all algorithms? (y/n)");
        String all = scan.nextLine();
        if (all == "n") {
            while(true) {
                System.out.println("Do you want to use Bubble Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    bubble = line;
                    if (line == "n") {
                        skip.add(0);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use Insertion Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    insertion = line;
                    if (line == "n") {
                        skip.add(1);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use Selection Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    selection = line;
                    if (line == "n") {
                        skip.add(2);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use Shell Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    shell = line;
                    if (line == "n") {
                        skip.add(3);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use Merge Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    merge = line;
                    if (line == "n") {
                        skip.add(4);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use MergeSelection Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    mergeSelection = line;
                    if (line == "n") {
                        skip.add(5);
                    }
                    break;
                }
            }
            while(true) {
                System.out.println("Do you want to use Quick Sort? (y/n)");
                line = scan.nextLine();
                if (line == "y" || line == "n") {
                    quick = line;
                    if (line == "n") {
                        skip.add(6);
                    }
                    break;
                }
            }
        } 

        System.out.println(" Now you can enter an Integer value for how big the list should be.");
        int lengde = (int) scan.nextInt();
        Integer[] testBubble, testInsertion, testSelection, testShell, testMerge, testMergeSelection, testQuick;
        testBubble = testInsertion = testSelection = testShell = testMerge = testMergeSelection = testQuick= null;

        if (bubble == "y")              {testBubble            = new Integer[lengde];}
        if (insertion == "y")      {testInsertion         = new Integer[lengde];}
        if (selection == "y")      {testSelection         = new Integer[lengde];}
        if (shell == "y")          {testShell             = new Integer[lengde];}
        if (merge == "y")          {testMerge             = new Integer[lengde];}
        if (mergeSelection == "y") {testMergeSelection    = new Integer[lengde];}
        if (quick == "y")          {testQuick             = new Integer[lengde];}
        

        StopWatch stopwatch = new StopWatch();

        stopwatch.start();
        System.out.println("Assessing "+ lengde + " random Integers to lists: ");
        int count = 1;
        for (int i = 0; i < lengde; i++) {
            int num =  random.nextInt(lengde * 5);
            if (bubble == "y")              {testBubble[i]           = num;}
            if (insertion == "y")      {testInsertion[i]        = num;}
            if (selection == "y")      {testSelection[i]        = num;}
            if (shell == "y")          {testShell[i]            = num;}
            if (merge == "y")          {testMerge[i]            = num;}
            if (mergeSelection == "y") {testMergeSelection[i]   = num;}
            if (quick == "y")          {testQuick[i]            = num;}
            
            if (i % 10000 == 0) {
                System.out.println(count * 10 + "% to finish");
                count++;
            }
        }
        stopwatch.stop();
        long elapsedTime = stopwatch.getElapsedTime();
        System.out.println("finished ✅ Time used: " + (elapsedTime / 1_000_000) + " ms");
        System.out.println("starting to process sorting algorithms ⏱️ ");
        stopwatch.reset();



        List<Integer[]> testSets = Arrays.asList(
            testBubble,
            testInsertion,
            testSelection,
            testShell,
            testMerge,
            testMergeSelection,
            testQuick
        );

        List<String> labels = Arrays.asList(
            "Bubble Sort",
            "InsertionSort",
            "Selection Sort",
            "Shell Sort",
            "Merge Sort",
            "Merge Sort with Selection algorithm on < 15",
            "Quick Sort"
        );
        
        boolean s;

        for (int i = 0; i < testSets.size(); i++) {
            s = false;
            if (skip.size() != 0) {
                for (int e = 0; e < skip.size(); e++) {
                    if (skip.get(e) == i) {
                        s = true;
                    }
                }
            }
            if (s == true) {
                continue;
            } else {
                stopwatch.start();
                String label = labels.get(i);
                Integer[] set = testSets.get(i);
                if (label == "Bubble Sort")                                         BubbleSort.sort(set);
                else if (label == "InsertionSort")                                  InsertionSort.sort(set);
                else if (label == "Selection Sort")                                 SelectionSort.sort(set);
                else if (label == "Shell Sort")                                     ShellSort.sort(set);
                else if (label == "Merge Sort")                                     MergeSort.sort(set);
                else if (label == "Merge Sort with Selection algorithm on < 15")    MergeSortSelection.sort(set);
                else if (label == "Quick Sort")                                     QuickSort.sort(set);
                stopwatch.stop();
                elapsedTime = stopwatch.getElapsedTime();
                System.out.println(label + " finished ✅ time usage: " + (elapsedTime / 1_000_000) + " ms   Sorted = " + isSorted(set));
            }
 
        }
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            } 
        } return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
