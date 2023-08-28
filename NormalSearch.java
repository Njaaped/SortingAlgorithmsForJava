



public class NormalSearch {

    public static boolean search(Comparable[] a, Comparable item) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

}
