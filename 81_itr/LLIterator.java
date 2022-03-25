public class LLIterator<T>{
  public DLLNode<T> pointer;
  public LList<T> list;
  public int idx;
  public LLIterator(LList<T> L){
    pointer = L.head;
    idx = 0;
    list = L;
  }

  public T next(){
    T cargo = pointer.getCargo();
    pointer = pointer.getNext();
    idx++;
    return cargo;
  }

  public boolean hasNext(){
    return pointer!=null;
  }

  public void remove(){
    list.remove(idx-1);
    idx--;
  }
}
