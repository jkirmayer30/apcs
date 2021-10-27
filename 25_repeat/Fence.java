/*
APCS
Jacob Kirmayer and Prattay Dey
10/25
time spent: 2 mins of class and 10min at home
*/
public class Fence{
  public static String fenceW(int fences){
    int built = 1;
    String result = "|";
    while(built<fences){
      result+="--|";
      built++;
    }
    return result;
  }
  public static String fenceR(int fences){
    if (fences==1){
      return "|";
    }else {
      return fenceR(fences-1)+"--|";
    }
  }
  public static void main(String[] args){
    System.out.println(fenceW(4));
    System.out.println(fenceR(4));
  }
}
