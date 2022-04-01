/***
 * class LLNode<T>
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode<T>
{
    //instance vars
    public String cargo;
    public LLNode<T> next;
    // constructor
    public LLNode( String value, LLNode<T> next )
    {
        this.cargo = value;
        this.next = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
        return cargo;
    }

    public LLNode<T> getNext()
    {
        return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo )
    {
        LLNode<T> temp = new LLNode<T>(this.cargo, this.next);
        this.cargo = newCargo;
        return newCargo;
    }

    public LLNode<T> setNext( LLNode<T> newNext )
    {
        LLNode<T> temp = getNext();
        this.next = newNext;
        return newNext;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
        return getCargo();
    }

}//end class LLNode<T>
