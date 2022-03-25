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

    public DLLNode<T> getNext()
    {
        return next;
    }

    public DLLNode<T>  next()
    {
      return next;
    }

    public DLLNode<T>  getPrev()
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

    public DLLNode<T>  setNext( DLLNode<T>  newNext )
    {
        this.next = newNext;
        return newNext;
    }

    public DLLNode<T>  setPrev( DLLNode<T>  newPrev )
    {
        this.prev = newPrev;
        return newPrev;
    }
    //--------------^  MUTATORS  ^--------------




}//end class DLLNode
