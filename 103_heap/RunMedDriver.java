/**
 * driver file for testing class RunMed
 * (RunMed provides for calculating a running median
 * of a stream of input ints)
 * USAGE: Runnable as-is.
 * Uncomment RunMed-specific lines below once RunMed is implemented.
 * Compile, run fr same dir as RunMed.java
 * to feed numbers manually:
 * $ java RunMed
 * to feed in prepared set:
 * $ java RunMed < input.nums
 * (input.nums provided; must be in same dir)
 * -------------------------
 * APCS pd6
 * JAWS: Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * time spent: 0.4 hrs
 * DISCO: Maintaining 2 piles of size differing by at most 1 is the best way to do this, so we only have to perform a logn
 * operation when we add certain items
 * 2018-05-17
 */

import java.util.Scanner;

public class RunMedDriver {
    public static void main(String[] args) {

        RunMed r = new RunMed();

        int n;
        double median;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            n = sc.nextInt();
            System.out.print("read " + n + "\n");

            count++;
            System.out.print("this many ints have been seen: " + count + "\n");

            r.add(n);
            median = r.getMedian();
            System.out.print("median is now " + median + "\n");
        }

    }//end main

}//end class