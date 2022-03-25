/**
 * / ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \
 * |  /~~\                                                       /~~\  |
 * |\ \   |  William Vongphanith, Jacob Kirmayer, Ari Gurovich  |   / /|
 * | \   /|                        APCS                         |\   / |
 * |  ~~  |            HW76 -- Building Linked Lists            |  ~~  |
 * |      |                     2022-03-14m                     |      |
 * |      |                Time elapsed: 0.8hrs                 |      |
 * |      |                                                     |      |
 * \     |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|     /
 *  \   /                                                       \   /
 *   ~~~                                                         ~~~
 * (generated with boxes -- boxes -a c d scroll <<< "design")
 */

// Uses the DLLNode<T> class from HW75 to construct the Linked List class.
// Note: I made the cargo and next variables public because I accidentally used the variables instead of the getter methods and refactoring would take a lot of time.


public class LList<T> implements List<T> {
    // Instance vars
    public DLLNode<T> head;
    private int size;

    // Constructor
    public LList() {
        head = null;
        size = 0;
    }

    // This adds to the beginning, but all the methods in the class behave as if it was adding to the end.
    public boolean add (T s) {
        this.head = new DLLNode<T>(s,this.head,null);
        if (size>0) {
            this.head.next.setPrev(this.head);
        }
	    size++;
	    return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.cargo;
    }

    public T set(int index, T s) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.cargo = s;
        return s;
    }

    public int size() {
        return size;
    }

    public T remove( int index ) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode<T> curr = head;
        for (int i = 0; i < index-1; i++) {
            curr = curr.next;
        }
        T old = curr.cargo;
        if (index==0){
            head = head.next;
        } else if (index==size-1) {
            curr.next = null;
        } else {
            curr.next = curr.next.next;
        }
        size--;
        return old;
    }

    public LLIterator<T> iterator(){
        return new LLIterator<T>(this);
    }

    // Other methods not in interface
    public String toString() {
        String result = "";
        DLLNode<T> curr = head;
        result += "["+curr.cargo.toString()+" -> ";
        curr = curr.next;
        while (curr != null) {
            result += curr.cargo.toString() + " -> ";
            curr = curr.next;
        }
        result +="]";
        return result;
    }

    public boolean add (T s, int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        DLLNode<T> curr = head;
        if (index==0){
            this.add(s);
            return true;
        }
        for (int i = 0; i < index-1; i++) {
            curr = curr.next;
        }
        curr.next = new DLLNode<T>(s, curr.next,curr);
        return true;
    }
}
