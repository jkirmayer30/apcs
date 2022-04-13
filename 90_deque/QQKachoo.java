import java.util.*;

public class QQKachoo<T> implements Deque<T>{
  private LinkedList<T> _data;
  public void addFirst(T x){
    _data.addFirst(x);
  }
  public void addLast(T x){
    _data.addLast(x);
  }
  public T removeFirst(){
    return _data.removeFirst();
  }
  public T removeLast(){
    return _data.removeLast();
  }
  public T getFirst(){
    return _data.getFirst();
  }
  public T getLast(){
    return _data.getLast();
  }
  public int size(){return _data.size();}

  public boolean isEmpty(){return _data.size()==0;}

  public void add(T x){
    _data.add(x);
  }

  public boolean addAll(Collection<T> c){
    return _data.addAll(c);
  }

  public boolean contains(T o){
    return _data.contains(o);
  }

  public Iterator<T> descendingIterator(){
    return _data.descendingIterator();
  }

  public T element(){
    return _data.element();
  }

  public Iterator<T> iterator(){
    return _data.iterator();
  }

  public boolean offer(T t){
    return _data.offer(t);
  }

  public boolean offerFirst(T t){
    return _data.offerFirst(t);
  }

  public boolean offerLast(T t){
    return _data.offerLast(t);
  }

  public boolean peek(){
    return _data.peek();
  }

  public boolean peekFirst(){
    return _data.peekFirst();
  }

  public boolean peekLast(){
    return _data.peekLast();
  }
}
