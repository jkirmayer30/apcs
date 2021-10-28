public class Stats{
    public static int gcd(int a, int b){
    int upperBound;
      if (a < b){
        upperBound = a;
      }
      else{
        upperBound = b;
      }
      while (!(a%upperBound==0&&b%upperBound==0)){
        upperBound--;
      }
      return upperBound;
    }
    public static int gcdER(int a, int b){
      if (a == b){
        return a;
      }
      else{
        if (a > b){
          return(gcd(a-b,b));
        }
        else{
          return(gcd(a,b-a));
        }
      }
    }
    public static int gcdEW(int a, int b){
      while (a != b){
        if (a > b){
          a = a -b;
        }
        else{
          b = b - a;
        }
      }
      return a;
    }
    public static void main(String[] args){
        System.out.println(gcd(15,18));
        System.out.println(gcdER(15,18));
        System.out.println(gcdEW(15,18));
    }
  }