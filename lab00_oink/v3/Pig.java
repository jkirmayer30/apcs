/*
Oinkin' Monkes -- Prattay Dey, Jacob Kirmayer, Jeffery Tang
APCS
L00 -- Pig Latin Translator
2021-11-08
time spent: 0.5 hours
DISCOS:
- Our initial attempts had many out-of-bounds errors during for loops, as our code allowed the index to exceed the array length.
- When trying to isolate a specific character in a string using subset(), the syntax is s.subset(char, char + 1) -- NOT simply s.subset(char)
QCCs:
- How would our methods be different if they took in a char input rather than a String?
TO DO LIST:
1) Ensure there are no errors in current code.
2) Test punctuation functionality.
3) Create method to separate each word of a sentence to use as an input for the translator and combine outputs to creat fully translated sentence.
new in v3:
input stream functionality

We utilized scanner demo to learn the scanner class and input stream and used the 
while loop in our project

The error in the demo scanner occurs because hasNext() is not checked before calling next() the second time in the while loop's procedure, and the number of words is odd.
*/
import java.util.Scanner;
public class Pig {

  private static final String VOWELS = "aeiouAEIOU";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";


/*=====================================
  boolean isPunc(String) -- tells whether a character is punctuation
  pre:  symbol.length() == 1
  post: isPunc(".") -> true
        isPunc("b") -> false
  =====================================*/
  public static boolean isPunc( String symbol ) {
    return PUNCS.indexOf( symbol ) != -1;
  }


/*=====================================
  boolean isUpperCase(String) -- tells whether a letter is uppercase
  pre:  letter.length() == 1
  post: isUpperCase("a") -> false
        isUpperCase("A") -> true
  =====================================*/
  public static boolean isUpperCase( String letter ) {
    return CAPS.indexOf( letter ) != -1;
  }


/*=====================================
  boolean hasPunc(String) -- tells whether a String contains punctuation
  pre:  w != null
  =====================================*/
  public static boolean hasPunc( String w ) {
    for (int idx =0;idx<w.length();idx++){
      if (isPunc(w.substring(idx,idx+1))){
        return true;
      }
    }
    return false;
  }


/*=====================================
  boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
  pre:  w != null and w.length() > 0
  post: beginsWithUpper("Apple") -> true
        beginsWithUpper("apple") -> false
  =====================================*/
  public static boolean beginsWithUpper( String w ) {
    return isUpperCase(w.substring(0,1) );
}


  /**
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p") -> false
  **/
  public static boolean hasA( String w, String letter ) {

    return w.indexOf(letter) != -1;

    /* equiv code, wo using indexOf()...
       boolean ans = false;
       for( int i = 0; i < w.length(); i++ ) {
       if ( w.substring(i,i+1).equals(letter) ) {
       ans = true;
       //Q: is there a more efficient way?
       }
       }
       return ans;
    */
  }//end hasA()


  /**
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    **/
  public static boolean isAVowel( String letter) {
    return hasA(VOWELS, letter );
  }

  // public static boolean hasVowelY( String w) {
  //   int idx = w.indexOf("y");
  //   if (idx==w.length()-1){return true;}
  //   if (idx>0){
  //     if (!isAVowel(w.substring(idx-1,idx))&&(!isAVowel(w.substring(idx+1,idx+2)))){
  //       return true;
  //     }
  //   }
  //   return false;
  // }


  /**
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    **/
  public static int countVowels( String w ) {

    return allVowels(w).length();

    /* long version using for
       int numVowels = 0; //init vowels counter var
       //must touch each letter in word, so use FOR
       for( int i = 0; i < w.length(); i++ ) {
       if ( isAVowel( w.substring(i,i+1) ) )
       numVowels++;
       }
       return numVowels;
    */
  }


  /**
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz") -> false
    **/
  public static boolean hasAVowel( String w ) {

    return countVowels(w) > 0;
  }


  /**
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    **/
  public static String allVowels( String w ) {

    String ans = ""; //init return String

    for( int i = 0; i < w.length(); i++ ) {

      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }


  /**
    String firstVowel(String) -- returns first vowel in a String
    pre:  w != null
    post: firstVowel("") --> ""
    firstVowel("zzz") --> ""
    firstVowel("meatball") --> "e"
    **/
  public static String firstVowel( String w ) {

    String ans = "";
    if ( hasAVowel(w) ) 
    //Q: Why this necess? A: to prevent having a string with no length from being read at index 0.
      ans = allVowels(w).substring(0,1);

    return ans;
  }


  /**
    boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
    pre:  w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
    **/
  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }


  /**
    String engToPig(String) -- converts an English word to Pig Latin
    pre:  w.length() > 0
    post: engToPig("apple")  --> "appleway"
    engToPig("strong") --> "ongstray"
    engToPig("java")   --> "avajay"
    **/
  public static String engToPig( String w ) {
    String ans = "";
    int idxOfSpc = w.indexOf(" ");
    if (w.length()==0){
      return "";
    }
    if(idxOfSpc>-1){
      return (engToPig(w.substring(0,idxOfSpc))+" "+engToPig(w.substring(idxOfSpc+1)));
    }

    if (beginsWithUpper(w)){
      String lower = w.toLowerCase();
      String result = engToPig(lower);;
      String newRes = (result.substring(0,1)).toUpperCase()+result.substring(1);
      return newRes;
    }

    if ( beginsWithVowel(w) ) {
      if (hasPunc(w)) {
        String p = w.substring(w.length()-1, w.length());
        ans = w.substring(0, w.length()-1) + "way" + p;
      } else {
        ans = w + "way";
      }
    }
    else {
      if (hasPunc(w)) {
        String p = w.substring(w.length()-1, w.length());
        int vPos = w.indexOf( firstVowel(w) );
        ans = w.substring(vPos, w.length()-1) + w.substring(0,vPos) + "ay" + p;
      } else {
        int vPos = w.indexOf( firstVowel(w) );
        ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }
    }

    return ans;
}


  public static void main( String[] args ) {
    Scanner inputStream = new Scanner(System.in);
    while ( inputStream.hasNext()) {
      String word = inputStream.nextLine();
      if (word.length()>0){
        System.out.println( "allVowels \t" + allVowels(word) );
        System.out.println( "firstVowels \t" + firstVowel(word) );
        System.out.println( "countVowels \t" + countVowels(word) );
        System.out.println( "engToPig \t" + engToPig(word) );
        System.out.println( "---------------------" );
      }
    }

  }//end main()

}//end class Pig
