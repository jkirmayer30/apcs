/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a T
 **/

import java.util.Iterator;
public class DLLNode<T>
{
    //instance vars
    public T cargo;
    public DLLNode next;
    public DLLNode prev;
    // constructor
    public DLLNode( T _value, DLLNode _next ,DLLNode _prev)
    {
        this.cargo = _value;
        this.next = _next;
        this.prev = _prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo()
    {
        return cargo;
    }

    public DLLNode getNext()
    {
        return next;
    }

    public DLLNode next()
    {
      return next;
    }

    public DLLNode getPrev()
    {
        return prev;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo )
    {

        this.cargo = newCargo;
        return newCargo;
    }

    public DLLNode setNext( DLLNode newNext )
    {
        this.next = newNext;
        return newNext;
    }

    public DLLNode setPrev( DLLNode newPrev )
    {
        this.prev = newPrev;
        return newPrev;
    }
    //--------------^  MUTATORS  ^--------------




}//end class DLLNode
