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

// Uses the DLLNode class from HW75 to construct the Linked List class.
// Note: I made the cargo and next variables public because I accidentally used the variables instead of the getter methods and refactoring would take a lot of time.

public class LList implements List {
    // Instance vars
    private DLLNode head;
    private int size;

    // Constructor
    public LList() {
        head = null;
        size = 0;
    }

    // This adds to the beginning, but all the methods in the class behave as if it was adding to the end.
    public boolean add (String s) {
        this.head = new DLLNode(s,this.head,null);
        if (size>0) {
            this.head.next.setPrev(this.head);
        }
	    size++;
	    return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.cargo;
    }

    public String set(int index, String s) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.cargo = s;
        return s;
    }

    public int size() {
        return size;
    }

    public String remove( int index ) {
        if (index < 0 || index >= size) {
            return null;
        }
        DLLNode curr = head;
        for (int i = 0; i < index-1; i++) {
            curr = curr.next;
        }
        String old = curr.cargo;
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

    // Other methods not in interface
    public String toString() {
        String result = "";
        DLLNode curr = head;
        result += "["+curr.cargo+" -> ";
        curr = curr.next;
        while (curr != null) {
            result += curr.cargo + " -> ";
            curr = curr.next;
        }
        result +="]";
        return result;
    }

    public boolean add (String s, int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        DLLNode curr = head;
        if (index==0){
            this.add(s);
            return true;
        }
        for (int i = 0; i < index-1; i++) {
            curr = curr.next;
        }
        curr.next = new DLLNode(s, curr.next,curr);
        return true;
    }
}
