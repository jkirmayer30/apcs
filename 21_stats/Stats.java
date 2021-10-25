
/**
   Jacob Kirmayer
   APCS
   HW21 --
   2021-10-21
disco: static methods are methods of a class
qcc: none
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

  public static int max(int a, int b, int c) {
    int maximum = a;
    if (b>maximum){
      maximum = b;
    }
    if (c>maximum){
      maximum = c;
    }

    return maximum;
  }
  
  public static double max(double a, double b, double c) {
    double maximum = a;
    if (b>maximum){
      maximum = b;
    }
    if (c>maximum){
      maximum = c;
    }

    return maximum;
  }
  
  public static int geoMean(int a, int b, int c) {
    double product = (a*b*c);
    double res =  Math.cbrt(product);
    return (int) res ;
  }
  
  public static double geoMean(double a, double b, double c) {
    return Math.cbrt(a*b*c);
  }

}//end class
