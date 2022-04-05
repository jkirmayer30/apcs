/***
 * APCS Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * HW 88-- RQueue
 * time spent: 0.3 hrs
 **/

public class RQueue<QUASAR> implements Queue<QUASAR>
{
  public LLNode<QUASAR> _head;
  public LLNode<QUASAR> _tail;
  public int size;


  public RQueue(){
    _head = null;
    _tail = null;
  }
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    shuffle();
    QUASAR tmp = _head.getCargo();
    _head = _head.getNext();
    size--;
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
    size++;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){return _head==null;}

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){return _head.getCargo();}

  public QUASAR shuffle(){
    int idx = (int) (Math.random()*size);
    LLNode<QUASAR> tmp = _head;
    for (int i = 0; i<idx;i++){
      tmp = tmp.getNext();
    }
    QUASAR tmpCargo = tmp.getCargo();
    tmp.setCargo(_head.getCargo());
    _head.setCargo(tmpCargo);
    return tmpCargo;
  }

  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<QUASAR> tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

  public static void main(String[] args){
    RQueue<Integer> q = new RQueue<Integer>();
    for (int x = 0; x<100;x++)
      q.enqueue(x);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }

}//end interface Queue
