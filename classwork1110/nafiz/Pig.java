/***
Heroes of the Zeroes - Nafiz Labib, Jing Yi Feng, Jomin Zhang
APCS
L00: Etterbay Odingcay Oughthray Ollaborationcay
2021-11-09
Time Spent: 2.0 hours
DISCO - 
- We added an instance called CAPSVOWELS and used it in vowel-related methods, such as beginsWithVowel. 
- The rule for y as consonant or vowel is mainly phonetic, which makes it hard to put exact rules in code. So, we did it partially, at least to satisfy the words given. Usually, if a word starts with y or a syllable in a word starts with y, the y is treated as a consonant. Usually it's a vowel when found elsewhere, whether in the middle or the very end.
- Scanner fails at "zzz"
QCC - 
- How do we have a whole sentence appear once rather than have the program run for every word in the sentence?
- How do we 
HOW WE UTILIZED SCANNER DEMO - (v4)
- Placed method for scanner within Pig.java and then created a new scanner object in main method to scan words.in file and return strings.  
WHAT CAUSES RUNTIME ERROR IN SCANTIME DEMO - 
- hasNext() is not checked before calling next() the second time in the loop.
NEW IN V_:
V0 - First Pig.java file supplied in ap251/library repo, without methods and instance variables supplied in lab
V1 - Pig.java includes methods and instance variables supplied in lab, tested and verified working. The general rules were tested and work. 
V2 - Pig.java has all rules tested and work EXCEPT Extra Rule #1(Consider y a vowel when appropirate).
V3 - Pig.java has all rules tested and work (somewhat, see DISCO for further details.)
***/

/***
 * Clyde "Thluffy" Sinclair
 * APCS
 * HW31 -- deploying linear search on Strings, using helper methods
 * 2021-11-04r
 * time spent: .5hrs
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
public class Pig {

    private static final String CAPSVOWELS = "AEIOUY";
    private static final String VOWELS = "aeiouy";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";
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
    return VOWELS.indexOf( letter ) != -1 || CAPSVOWELS.indexOf( letter ) != -1;

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
    if (w.substring(0,1).equals("y") || w.substring(0,1).equals("Y"))
      ans = allVowels(w).substring(1,2);
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
	return CAPS.indexOf(letter) != -1;
    }
    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc("cat.") -> true
            hasPunc("cat") -> false
   =====================================*/
    public static boolean hasPunc( String w ) {
	  boolean punc = false;
  for (int i=0; i < w.length(); i++){
    if (isPunc(w.substring(i,i+1))){
    punc = true;
    }
  }
  return punc;
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
    String engToPig(String) -- converts an English word to Pig Latin
    pre:  w.length() > 0
    post: engToPig("apple")  --> "appleway"
    engToPig("strong") --> "ongstray"
    engToPig("java")   --> "avajay"
    **/
  public static String engToPig( String w ) {
    String ans = "";

    
    if ( beginsWithVowel(w) && ! w.substring(0,1).equals("y") && ! w.substring(0,1).equals("Y")){
      ans = w + "way";
    }
    else if(! hasAVowel(w)){
      ans = w;	
    }
    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }

    String allPunc = "";
    if ( hasPunc(w) ){
    for (int i = 0; i <= ans.length(); i++){
    if (isPunc(ans.substring(i,i+1))){
    allPunc +=  ans.substring(i,i+1);
    	}
    ans = ans.substring(0,i) + ans.substring(i+1,ans.length()) + allPunc;
    }
    }
     if ( beginsWithUpper(w) ){
    ans = ans.toLowerCase();
    ans = ans.substring(0,1).toUpperCase() + ans.substring(1,ans.length());
     }
    return ans;
  }
  public static void main( String[] args ) {
    try {
      File words = new File("words.in");
      Scanner fileReader = new Scanner(words);
      while (fileReader.hasNextLine()) {
        String input = fileReader.nextLine();
        System.out.println(engToPig(input));
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }

    Scanner sc = new Scanner( System.in );
    while( sc.hasNext() ) {
      String input = sc.next();
      System.out.println(engToPig(input));
    }

    if(word.length() > 0){
      System.out.println( "allVowels \t" + allVowels(word) );
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println("hasPunc \t" + hasPunc(word));
      System.out.println("beginsWithUpper \t" + beginsWithUpper(word));
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );

	  }
  }//end main()
}//end class Pig
