/***
 * class LLNode<T>
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode<T>
{
    //instance vars
    public T cargo;
    public LLNode<T> next;
    // constructor
    public LLNode( T value, LLNode<T> next )
    {
        this.cargo = value;
        this.next = next;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo()
    {
        return cargo;
    }

    public LLNode<T> getNext()
    {
        return next;
    }
    //--------------^  ACCESSORS  ^--------------

    public LLNode<T> setNext( LLNode<T> newNext )
    {
        LLNode<T> temp = getNext();
        this.next = newNext;
        return newNext;
    }

    public void setCargo(T stuff){cargo = stuff;}
    //--------------^  MUTATORS  ^--------------
}//end class LLNode<T>
