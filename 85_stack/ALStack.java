import java.util.ArrayList;

public class ALStack<PANCAKE>{
    ArrayList<PANCAKE> _data;
    //Return true if this stack is empty, otherwise false.

    public ALStack() {
        _data = new ArrayList<PANCAKE>();
    }

    public boolean isEmpty(){return _data.size()==0;}

    //Return top element of stack without popping it.
    public PANCAKE peekTop(){
        return _data.get(_data.size()-1);
    }

    //Pop and return top element of stack.
    public PANCAKE pop(){
        if (_data.size()>0) {
            PANCAKE topCake = _data.get(_data.size()-1);
            _data.remove(_data.size()-1);
            return topCake;
        } else {return null;}
    }

    //Push an element onto top of this stack.
    public void push( PANCAKE x ){
        _data.add(x);
    }
}