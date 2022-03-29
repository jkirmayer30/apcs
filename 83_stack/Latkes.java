/***
 * APCS Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * HW 83-- Stacks on Stacks
 * time spent: 0.3 hrs
 **/

/***
    DISCO
      Why use this instead of a regular AL?
    QCC
      What else should a stack be able to do?
 **/


public class Latkes
{
  private String[] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(?)


  //means of insertion
  public void push( String s )
  {
    if (_stack.length==_stackSize){
      String[] newArr = new String[2*_stackSize];
      for (int i=0;i<_stackSize;i++){
        newArr[i] = _stack[i];
      }
      _stack = newArr;
    }
    _stackSize++;
    _stack[_stackSize-1] = s;
  }


  //means of removal
  public String pop( )
  {
    if (_stackSize>0) {
      String str = _stack[_stackSize - 1];
      _stack[_stackSize - 1] = "";
      _stackSize--;
      return str;
    } else {return null;}

  }// O(?)


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize==0;
  }// O(?)


  //chk for fullness
  public boolean isFull()
  {
    return _stack.length==_stackSize;
  }// O(?)


  //main method for testing
  public static void main( String[] args )
  {
    Latkes tastyStack = new Latkes(5);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println(tastyStack.isEmpty());
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    System.out.println(tastyStack.isEmpty());

  }//end main()

}//end class Latkes
