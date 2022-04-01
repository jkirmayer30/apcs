/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: Two Stack System
    * One Stack for numbers and parens, one for operators
    * This way we don't have to dig for operator in a stack with nums and parens
    * Prefix notation means that the most recent operation in the string might not
    * be the one that needs to be executed eg.(+ (* 5 2) 4), tghe last operation to execute
    * is addition. A structure where the operator comes after the operands would be better
    * suited to the one-stack structure.
 **/

import java.util.ArrayList;

class Stack<Pancake> {
    private ArrayList<Pancake> stack;

    public Stack() {
        stack = new ArrayList<Pancake>();
    }

    public void push(Pancake pancake) {
        stack.add(pancake);
    }

    public Pancake pop() {
        return stack.remove(stack.size() - 1);
    }

    public Pancake peekTop() {
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}


public class Scheme
{
    /***
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     **/
    public static String evaluate( String expr )
    {
        Stack<String> mainStack = new Stack();
        Stack<String> opStack = new Stack();
        String[] exps = expr.split("\\s+");
        for (String exp : exps) {
//            System.out.println(exp);
            if (exp.equals("+")||exp.equals("-")||exp.equals("*")) {
                opStack.push(exp);
            } else if (exp.equals(")")) {
                String currOp = opStack.peekTop();
                int mostRecentOperator;
                if (currOp.equals("+")){
                    mostRecentOperator = 1;
                } else if (currOp.equals("-")){
                    mostRecentOperator = 2;
                }else{
                    mostRecentOperator = 3;
                }
                String result = unload(mostRecentOperator, mainStack);
                opStack.pop();
                mainStack.push(result);
            } else {
                mainStack.push(exp);
            }
        }
        return mainStack.peekTop();
    }


    /***
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     **/
    public static String unload( int op, Stack<String> numbers )
    {
        int result = Integer.parseInt( numbers.pop());
        if (op == 1) {
            while (!numbers.peekTop().equals("(")) {
//                System.out.println(result);
                result += Integer.parseInt(numbers.pop());
            }
        } else if (op == 2) {
            result *=-1;
            while (!numbers.peekTop().equals("(")) {
                int nextVal = Integer.parseInt(numbers.pop());
                if (!numbers.peekTop().equals("(")){
                    result -=nextVal;
                } else { result +=nextVal;}
            }
        } else {
            while (!numbers.peekTop().equals("(")) {
                result = result * Integer.parseInt(numbers.pop());
            }
        }
        numbers.pop();
        return Integer.toString(result);
    }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


    //main method for testing
    public static void main( String[] args )
    {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7
      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17
      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29
      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
    }//main()

}//end class Scheme