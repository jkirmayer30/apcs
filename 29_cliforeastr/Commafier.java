/*
JPH -- Hugo Jenkins, Prattay Dey, Jacob Kirmayer
APCS
HW 29 -- Which Way Do You Role?
2021-11-02
time spent: 0.5 hours
DISCO:
toString() is a method within class Integer which returns the String form of an Integer
Use the for each method when you want to run through each object in an array
QCC:
Is it ever smart to run through the parts of an array manually by using a normal for loop?
*/

public class Commafier{

  public static String commafyR(int i){
    String blep = Integer.toString(i);
    if (i<1000){
      return blep;
    }
    String lastpart = blep.substring(blep.length()-3,blep.length());
    int firstpart = i/1000;
    return commafyR(firstpart)+","+lastpart;
  }

  public static String commafyF(int i){
    String blep = Integer.toString(i);
    String ans = "";
    for (int idx = blep.length()-1;idx > 0;idx = idx - 1){
      ans = blep.substring(idx,idx+1) + ans;
      if (idx%3 == blep.length()%3){
        ans = "," + ans;
      }
    }
    ans = blep.substring(0,1)+ans;
    return ans;
  }

  public static void main(String[] args){
    for (String arg : args){
      System.out.println(commafyR(Integer.parseInt(arg)));
    }
  }
}
