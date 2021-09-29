 public class Methods {

      public static Boolean isDivisible(int n,int m){
          return (n%m==0);
      }

      public static Boolean isTriangle(float a,float b,float c){
          return (a+b>c&a+c>b&b+c>a);
      }
      
      public static int ack(int m, int n){
          if (m==0){
              return n+1;
          } else if(n==0){
              return ack(m - 1, 1);
          } else {
              return(ack(m-1,ack(m,n-1)));
          }
      }

      public static void main(String[] args){
          System.out.println(isDivisible(4,2));
          System.out.println(isTriangle(4,2,1));
          System.out.println(ack(2,2));
      }

  }