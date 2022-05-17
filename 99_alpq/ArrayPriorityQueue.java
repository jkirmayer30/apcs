public class ArrayPriorityQueue {
    private OrderedArrayList _data;

    //O(1)
    public ArrayPriorityQueue(){
        _data = new OrderedArrayList();
    }

    //O(n)
    public void add( int x ){
        _data.add(x);
    }

    //O(1)
    public boolean isEmpty(){return _data.size()==0;}

    //O(1)
    public int peekMin(){return _data.get();}

    //O(1)
    public int removeMin(){return _data.remove();}

    public static void main(String[] args){
        ArrayPriorityQueue bob = new ArrayPriorityQueue();
        System.out.println(bob.isEmpty());
        bob.add(23);
        System.out.println(bob.isEmpty());
        bob.add(22);
        System.out.println(bob.peekMin());
        System.out.println(bob.removeMin());
    }
}
