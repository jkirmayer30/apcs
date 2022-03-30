/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
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
