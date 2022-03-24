public class LLIterator<T>{
  public DLLNode<T> pointer;
  public LLIterator(LList<T> L){
    pointer = L.head;
  }

  public T next(){
    T cargo = pointer.getCargo();
    pointer = pointer.getNext();
    return cargo;
  }

  public boolean hasNext(){
    return pointer.getNext()==null;
  }

  public void remove(){
    if (pointer.getPrev()!=null){
      pointer.getPrev().next=pointer.getNext();
    }
    if (pointer.getNext()!=null){
      pointer.getNext().prev=pointer.getPrev();
    }
  }
}
