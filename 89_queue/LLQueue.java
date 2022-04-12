import java.util.*;

public class LLQueue<T> {
    private LinkedList<T> _data;

    public LLQueue(){
        _data = new LinkedList<T>();
    }

    public T dequeue(){
        return _data.removeFirst();
    };

    public void enqueue( T x ){
        _data.addLast(x);
    };

    public T peekFront(){
        return _data.get(0);
    };

    public static void main(String[] args){
        LLQueue<String> q = new LLQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        System.out.println(q.dequeue());
        System.out.println(q.peekFront());
        System.out.println(q.dequeue());
    }
}