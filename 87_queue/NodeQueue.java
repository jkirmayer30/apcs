/***
 * APCS Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * HW 87-- Queue
 * time spent: 0.3 hrs
 **/

public class NodeQueue<QUASAR> implements Queue<QUASAR>
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
    QUASAR tmp = _head.getCargo();
    _head = _head.getNext();
    return tmp;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
    if (_head==null){
      _head = new LLNode<QUASAR>(x,null);
      _tail = _head;
    } else {
      _tail.setNext(new LLNode<QUASAR>(x,null));
      _tail = _tail.getNext();
    }
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){return _head==null;}

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){return _head.getCargo();}
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

}//end interface Queue
