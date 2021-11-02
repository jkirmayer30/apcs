public class TestClass{
public static int countHi(String str) {
  int hiCount = 0;
  for (int idx = 0; idx<str.length()-1;idx++){
    System.out.println(str.substring(idx,idx+2));
    if (str.substring(idx,idx+2).equals("hi")){
      System.out.println("counted");
      hiCount++;
    }
  }
  return hiCount;
}
public static void main(String[] args){
System.out.println(countHi("hihi"));
}
}
