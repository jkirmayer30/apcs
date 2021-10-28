/*
JPH- Jacob Kirmayer, Prattay Dey, Hugo Jenkins
APCS
HW26 -- GCD Three Ways
2021-10-27
time spent: 0.75 hours
*/
/*
DISCO:
There are many ways to code the same thing, all of which are correct
QCC:
How do we know which is the best code for the job?
Which takes the computer the least computations?
ALGO:
For both GCDER and GCDEW, we work on working a and b down to the same number by using the rule thatthe GCD of 2 numbers remains the same if the larger number is replaced by its difference with the smaller number. 
*/
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