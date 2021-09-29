 public class Loops {

      public static int power(int x,int n){
          int result = 1;
          for (int a =0;a<n;a++){
              result*=x;
          }
          return result;
      }

      public static int factorial(int n){
        int result = 1;
        for (int a =1;a<n+1;a++){
            result*=a;
        }
        return result;
      }
      
      public static float myexp(float x, float n){
          float currentTerm = 1;
          float total = 1;
          for (float a =1;a<n;a++){
            currentTerm*=x/a;
            total+=currentTerm;
        }
        return total;
      }

      public static void main(String[] args){
          System.out.println(myexp(4,7));
          System.out.println(factorial(4));
          System.out.println(power(2,2));
      }

  }