public class LLStack<PANCAKE>{
  LList<PANCAKE> _data;
  //Return true if this stack is empty, otherwise false.

  public LLStack() {
    _data = new LList<PANCAKE>();
  }

  public boolean isEmpty(){return _data.size()==0;}

  //Return top element of stack without popping it.
  public PANCAKE peekTop(){
    return _data.get(0);
  }

  //Pop and return top element of stack.
  public PANCAKE pop(){
    if (_data.size()>0) {
      PANCAKE topCake = _data.get(0);
      _data.removeFirst();
      return topCake;
    } else {return null;}
  }

  //Push an element onto top of this stack.
  public void push( PANCAKE x ){
    _data.addFirst(x);
  }
}
