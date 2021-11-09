/*
JPH -- Hugo Jenkins, Prattay Dey, Jacob Kirmayer
APCS
HW 31 -- ?
2021-11-02
time spent: 0.5 hours
DISCOS:
- Our initial attempts had many out-of-bounds errors during for loops, as our code allowed the index to exceed the array length.
- When trying to isolate a specific character in a string using subset(), the syntax is s.subset(char, char + 1) -- NOT simply s.subset(char)
QCCs:
- How would our methods be different if they took in a char input rather than a String?

*/
public class Pig {

  private static final String VOWELS = "aeiou";
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
  post: hasPunc(“cat.”) -> true
        hasPunc(“cat”) -> false
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
  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }


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

    if ( hasAVowel(w) ) //Q: Why this necess?
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

    if ( beginsWithVowel(w) )
      ans = w + "way";

    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }

    return ans;
  }


  public static void main( String[] args ) {

    for( String word : args ) {
      System.out.println( "allVowels \t" + allVowels(word) );
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );
    }

  }//end main()

}//end class Pig
