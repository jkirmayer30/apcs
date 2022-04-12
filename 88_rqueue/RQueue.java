/***
<<<<<<< HEAD
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = 0;
    _size = 0;
  }


  public void enqueue( T enQVal )
  {

  }//O(?)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {

  }//O(?)


  public T peekFront()
  {
    return _front.getValue();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample ()
  {

  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String foo = "";
    LLNode<SWASHBUCKLE> tmp = _front;
    while ( tmp != null ) {
      foo += tmp.getValue() + " ";
      tmp = tmp.getNext();
    }
    return foo;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
=======
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
>>>>>>> 0c425f6c477a0063a278274e92a3003213ba37dc
