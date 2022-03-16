/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
    //instance vars
    public String cargo;
    public LLNode next;
    public LLNode prev;
    // constructor
    public LLNode( String _value, LLNode _next ,LLNode _prev)
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

    public LLNode getNext()
    {
        return next;
    }
    
    public LLNode getPrev()
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

    public LLNode setNext( LLNode newNext )
    {
        this.next = newNext;
        return newNext;
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
        LLNode first = new LLNode( "cat",null, null );

        //Create a new node after the first
        first.setNext( new LLNode( "dog", first,null ) );

        //Create a third node after the second
        first.getNext().setNext( new LLNode( "cow", first.getNext(),null ) );

        // Better traversal, doesn't garbage collect
        LLNode current = first;
        while ( current != null )
        {
            System.out.println( current.getCargo() );
            current = current.getNext();
        }
    }//end main

}//end class LLNode
