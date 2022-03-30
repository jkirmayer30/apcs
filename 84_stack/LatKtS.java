/***
 * APCS Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * HW 84-- Stack: What is it good for?
 * time spent: 0.3 hrs
 **/

/***
 DISCO
 Practical use of stack: maintaining a stack of things that need to be closed/resolved during'
 a traversal
 QCC
 **/
public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    String result = "";
    Latkes newStack = new Latkes(s.length());
    for (int i = 0; i<s.length(); i++){
      newStack.push(s.substring(i, i+1));
    }
    result += newStack.pop();
    return result;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes unClosed = new Latkes(s.length());
    for (int i = 0; i<s.length(); i++){
      String character = s.substring(i, i+1);
      String popped = unClosed.pop();
      if (popped==null) {
        unClosed.push(character);
      }else if ((!character.equals(")")&&popped.equals("("))||
              (!character.equals("]")&&popped.equals("["))||
              (!character.equals("}")&&popped.equals("{"))){
        unClosed.push(popped);
        unClosed.push(character);
      }
    }
    return unClosed.isEmpty();
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
  }

}//end class
