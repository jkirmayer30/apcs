/*
JWJ (Jefford Shau, William Vongphanith, Jacob Kirmayer)
APCS
HW35 -- A Pirate's Life for Me
2021-11-15
time spent: 0.5 hrs
*/

/*
DISCO:
  0. The line import java.util.Arrays was unnecessary. The code ran without the Arrays class. 
QCC:
  0. How would you slice an array from the last index instead of from the first index? 
*/

public class Loopier {

  public static int[] init(int[] array) {
    for(int i = 0; i < array.length; i ++) {
      array[i] = (int)(Math.random() * 64920);
    }
    return array;
  }

  public static String toString(int[] array) {
    String arrayString = "[";
    for(int i = 0; i < array.length; i++) {
      arrayString += array[i];
      if (i != array.length - 1) {
        arrayString += ", ";
      }
    }
    return arrayString + "]";
  }

  public static int linSearch(int[] a, int target) {
    for(int i = 0; i < a.length; i ++) {
      if (a[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int linSearchR(int[] a, int target) {
    int idx = 0;
    if (a.length == 0) {
      return -1;
    }
    if (a[0] == target) {
      return idx;
    }
    if (a.length > 0) {
      idx += 1;
      a = Sliceby1(a);
      if (linSearchR(a, target) != -1) { // for test 4
        return idx + linSearchR(a, target);
      }
    }
    return -1;
  }

  public static int[] Sliceby1(int[] a) {
    int[] sliced = new int[a.length - 1];
    for(int i = 1; i < a.length; i++) {
      sliced[i - 1] = a[i];
    }
    return sliced;
  }

  public static int freq(int[] a, int target) {
    int counter = 0;
    for(int i = 0; i < a.length; i ++) {
      if (a[i] == target) {
        counter += 1;
      }
    }
    return counter;
  }


  public static int freqRec(int[] a, int target) {
    int idx = 0;
    if (a.length == 0) {
      return idx;
    }
    else {
      if (a[0] == target) {
        idx += 1;
        a = Sliceby1(a);
        return idx + freqRec(a, target);
      }
      else {
        a = Sliceby1(a);
        return idx + freqRec(a, target);
      }
    }
  }

  public static void main(String[] args) {
    //test init and toString method
    int[] init1 = new int[3];
    System.out.println("init1 = " + toString(init(init1)));
    int[] init2 = new int[4];
    System.out.println("init1 = " + toString(init(init2)));
    int[] init3 = new int[5];
    System.out.println("init1 = " + toString(init(init3)));

    //test linSearch methods
    int[] linSearch1 = {1, 3, 5, 7, 9};
    int[] linSearch2 = {};
    int[] linSearch3 = {5};
    System.out.println("Linear Search Iteration");
    System.out.println(linSearch(linSearch1, 7));
    System.out.println(linSearch(linSearch2, 5));
    System.out.println(linSearch(linSearch3, 5));
    System.out.println(linSearch(linSearch3, 3));
    System.out.println("Linear Search Recursion");
    System.out.println(linSearchR(linSearch1, 7));
    System.out.println(linSearchR(linSearch2, 5));
    System.out.println(linSearchR(linSearch3, 5));
    System.out.println(linSearchR(linSearch3, 3));

    //test freq methods
    int[] freq1 = {1, 1, 5, 6, 8, 9, 9, 1, 9, 6, 6, 6, 1, 1, 10};
    int[] freq2 = {};
    int[] freq3 = {1};
    System.out.println("Frequency Iteration");
    System.out.println(freq(freq1, 6));
    System.out.println(freq(freq1, 5));
    System.out.println(freq(freq2, 7));
    System.out.println(freq(freq3, 5));
    System.out.println(freq(freq3, 1));
    System.out.println("Frequency Recursion");
    System.out.println(freqRec(freq1, 6));
    System.out.println(freqRec(freq1, 5));
    System.out.println(freqRec(freq2, 7));
    System.out.println(freqRec(freq3, 5));
    System.out.println(freqRec(freq3, 1));
  }
}
