import java.util.*;

public class ALQueue<T> {
    private ArrayList<T> _data;

    public ALQueue(){
        _data = new ArrayList<T>();
    }

    public T dequeue(){
       return _data.remove(0);
    };

    public void enqueue( T x ){
        _data.add(x);
    };

    public T peekFront(){
       return _data.get(0);
    };

    public static void main(String[] args){
        ALQueue<String> q = new ALQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        System.out.println(q.dequeue());
        System.out.println(q.peekFront());
        System.out.println(q.dequeue());
    }
}
