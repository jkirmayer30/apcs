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
public class Pig
{
  //Q: How does this initialization make your life easier?
  // It provides a list of vowels if we choose to read it, also we know it can't change
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    return -1<w.indexOf(letter);
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    return letter.equals("a") || letter.equals("e") || letter.equals("i") ||
    letter.equals("o") || letter.equals("u");
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    int ans = 0;
    for(int i = 0;i<w.length();i=i+1){
      if (isAVowel(w.substring(i,i+1))){
        ans = ans + 1;
      }
    }
    return ans;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
    return countVowels(w)>0;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    String anw = "";
    for(int i = 0;i<w.length();i=i+1){
      if (isAVowel(w.substring(i,i+1))){
        anw = anw + w.substring(i,i+1);
      }
    }
    return anw;
  }


  public static void main( String[] args ) {
    System.out.println(hasA("hello", "b")); // 0 occurences, return -1
    System.out.println(hasA("hello", "e")); // 1 occurence
    System.out.println(hasA("hello", "l")); // 2 occurences

    System.out.println(isAVowel("e")); // true
    System.out.println(isAVowel("f")); // false

    System.out.println(countVowels("fxn")); // 0 vowels
    System.out.println(countVowels("armor")); // 2 vowels

    System.out.println(hasAVowel("fxn")); // false
    System.out.println(hasAVowel("armor")); // true

    System.out.println(allVowels("aloe")); // "aoe"
    System.out.println(allVowels("fxn")); // ""
  }//end main()

}//end class Pig