/*
JPH: Jacob Kirmayer, Hugo Jenkins, Prattay Dey
apcs
classwork 21
2021-10-20
disco:
static methods are methods of classes, geo mean is the square root of the product of two numbers
qcc:
How do you import in java?
*/

public class StatsDriver{
  public static void main(String[] args){
    System.out.println(Stats.mean(2,4)); //3
    System.out.println(Stats.mean((double) 21,(double) 34)); //27.5
    System.out.println(Stats.max(2,4));//4
    System.out.println(Stats.max(4,4));//4
    System.out.println(Stats.max((double) 21,(double) 34)); //34
    System.out.println(Stats.max((double) 21,(double) 21)); //21
    System.out.println(Stats.geoMean(16,4)); //8
    System.out.println(Stats.geoMean((double) 12,(double)3 )); //6
    System.out.println(Stats.geoMean((double) -12,(double)3 )); //imaginary or error
  }
}
