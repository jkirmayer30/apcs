public class LLStack<PANCAKE>{
  LList<PANCAKE> _data;
  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){return _data.size()==0;}

  //Return top element of stack without popping it.
  public PANCAKE peekTop(){
    return _data.get(0);
  }

  //Pop and return top element of stack.
  public PANCAKE pop(){
    PANCAKE topCake = _data.get(0);
    _data.removeFirst();
    return topCake;
  }

  //Push an element onto top of this stack.
  public void push( PANCAKE x ){
    _data.addFirst(x);
  }
}
