
/**
   Clyde "Thluffy" Sinclair
   APCS
   HW20 --
   2021-10-21
   xtra: harmonic mean is the reciprocal of the
   arithmetic mean of the reciprocals
 **/

public class Stats {

  public static int mean(int a, int b) {
    return (a + b)/2;
  }

  public static double mean(double a, double b) {
    return (a + b)/2;
  }

  public static int max(int a, int b) {
    if (a>b){return a;}else {return b;}
  }

  public static double max(double a, double b) {
    if (a>b){return a;}else {return b;}
  }

  public static int geoMean(int a, int b) {
    return (int) Math.sqrt(a*b);
  }

  public static double geoMean(double a, double b) {
    return Math.sqrt(a*b);
  }

  // public static int max(int a, int b, int c) {
  //
  // }
  //
  // public static double max(double a, double b, double c) {
  //
  // }
  //
  // public static int geoMean(int a, int b, int c) {
  //
  // }
  //
  // public static double geoMean(double a, double b, double c) {
  //
  // }
  //
  //
  // //main method for testing functionality
  // public static void main( String[] args ) {
  //
  // }

}//end class
