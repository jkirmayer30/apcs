/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static boolean allMatched( String s )
  {
//    LLStack<String> unClosed = new LLStack<String>();
    ALStack<String> unClosed = new ALStack<String>();
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
  public static void main( String[] args )
{
//  System.out.println(allMatched( "({}[()])" )); //true
  System.out.println(allMatched( "([)]" ) ); //false
  System.out.println(allMatched( "(){([])}" ) ); //true
  System.out.println(allMatched( "](){([])}" ) ); //false
  System.out.println(allMatched( "(){([])}(" ) ); //false
  System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
}



}//end class
