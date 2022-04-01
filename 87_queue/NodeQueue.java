
public class NodeQueue<QUASAR>
{
  public LLNode<QUASAR> _head;
  public LLNode<QUASAR> _tail;


  public NodeQueue(){
    _head = null;
    _tail = null;
  }
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    _tail = _tail.getNext();
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
    if (_head.equals(null)){
      _head = x;
      _tail = x;
    } else {_head.setNext(x);}
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty();

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront();
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

}//end interface Queue
