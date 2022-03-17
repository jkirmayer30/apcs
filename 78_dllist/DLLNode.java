/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
    //instance vars
    public String cargo;
    public DLLNode next;
    public DLLNode prev;
    // constructor
    public DLLNode( String _value, DLLNode _next ,DLLNode _prev)
    {
        this.cargo = _value;
        this.next = _next;
        this.prev = _prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
        return cargo;
    }

    public DLLNode getNext()
    {
        return next;
    }
    
    public DLLNode getPrev()
    {
        return prev;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo )
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


    // override inherited toString
    public String toString()
    {
        return getCargo();
    }


    //main method for testing
    public static void main( String[] args )
    {

        //Below is an exercise in creating a linked list...

        //Create a node
        DLLNode first = new DLLNode( "cat",null, null );

        //Create a new node after the first
        first.setNext( new DLLNode( "dog", first,null ) );

        //Create a third node after the second
        first.getNext().setNext( new DLLNode( "cow", first.getNext(),null ) );

        // Better traversal, doesn't garbage collect
        DLLNode current = first;
        while ( current != null )
        {
            System.out.println( current.getCargo() );
            current = current.getNext();
        }
    }//end main

}//end class DLLNode
