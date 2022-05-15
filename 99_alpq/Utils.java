import java.util.ArrayList;

public class Utils {
    // average of two integers
    public static int average(int a, int b) {
        return (a + b) / 2;
    }

    public static int binarySearchInsert (ArrayList<Integer> arr, Integer value) {
        if (arr.size() == 0)
            return 0;
        int low = 0;
        int high = arr.size();
        if (value.compareTo(arr.get(0))>0)
            return 0;
        while (true) {
            if (high<low+2) {
                return low+1;
            }
            if (value.compareTo(arr.get(average(low, high)))<0) {
                low = average(low, high);
            }else if (value.compareTo(arr.get(average(low, high)))>0) {
                high = average(low, high);
            } else {
                return average(low,high)+1;
            }
        }
    }
}