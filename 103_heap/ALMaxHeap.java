/**
 * APCS pd6
 * JAWS: Jacob Kirmayer, Ari Gurovich, William Vongphanith
 * time spent: 0.8 hrs
 * DISCO: Remove and add can be done in log time
 * QCC: Is there a faster way to remove
 */

import java.util.ArrayList;

public class ALMaxHeap {

    //instance vars
    private ArrayList<Integer> _heap;

    /**
     * default constructor  ---  inits empty heap
     */
    public ALMaxHeap() {
        _heap = new ArrayList<Integer>();
    }


    /**
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     */
    public String toString() {
        int height = (int) (Math.log(_heap.size()) / Math.log(2) + 1);
        int layerLength = 1;
        int idx = 0;
        int spaceSize = (int) Math.pow(2, height) - 1;
        String res = "";
        for (int layer = 0; layer < height; layer++) {
            for (int sp = 0; sp < 2 * (spaceSize - 1) / 2; sp++)
                res += " ";
            for (int i = 0; i < layerLength; i++) {
                if (idx < _heap.size()) {
                    res += _heap.get(idx).toString();
                    for (int sp = 0; sp < 2 * spaceSize; sp++)
                        res += " ";
                    idx++;
                }
            }
            layerLength *= 2;
            spaceSize = (spaceSize - 1) / 2;
            res += "\n";
        }
        return res;
    }//O(n)


    /**
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     */
    public boolean isEmpty() {
        return _heap.size() == 0;
    }//O(?)

    public int size(){return _heap.size();}


    /**
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     */
    public Integer peekMax() {
        return _heap.get(0);
    }//O(?)


    /**
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * ALGO:
     * Add the value at the last idx in the AL
     * Swap it with its parent if the parent is bigger
     * Repeat
     */
    public void add(Integer addVal) {
        _heap.add(addVal);
        int currIdx = _heap.size() - 1;
        int parentPos = (currIdx - 1) / 2;
        int parent = _heap.get(parentPos);
        while (parent < addVal && currIdx > 0) {
            swap(parentPos, currIdx);
            currIdx = parentPos;
            parentPos = (currIdx - 1) / 2;
            parent = _heap.get(parentPos);
        }
    }//O(logn)


    /**
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * ALGO:
     * Walk root down and keep swapping it with its smallest children until its at a leaf
     * Swap that leaf with the last element of the list. If it was the last element before the swap, stop here.
     * If it wasn't, walk the swapped item up the tree
     */
    public Integer removeMax() {
        int idx = 0;
        while (maxChildPos(idx) > 0) {
            swap(idx, maxChildPos(idx));
            idx = maxChildPos(idx);
        }
        swap(idx, _heap.size() - 1);
        if (idx != _heap.size() - 1){
            int addVal = _heap.get(idx);
            int currIdx = idx;
            int parentPos = (currIdx - 1) / 2;
            int parent = _heap.get(parentPos);
            while (parent < addVal && currIdx > 0) {
                swap(parentPos, currIdx);
                currIdx = parentPos;
                parentPos = (currIdx - 1) / 2;
                parent = _heap.get(parentPos);
            }
        }
        return _heap.remove(_heap.size() - 1);
    }//O(logn)


    /**
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     */
    private int maxChildPos(int pos) {
        if (2 * pos + 2 < _heap.size()) {
            if (_heap.get(2 * pos + 2) > _heap.get(2 * pos + 1)) {
                return 2 * pos + 2;
            } else {
                return 2 * pos + 1;
            }
        } else if (2 * pos + 2 == _heap.size()) {
            return 2 * pos + 1;
        } else {
            return -1;
        }
    }//O(1)


    //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
    private Integer maxOf(Integer a, Integer b) {
        if (a.compareTo(b) < 0)
            return a;
        else
            return b;
    }

    //swap for an ArrayList
    private void swap(int pos1, int pos2) {
        _heap.set(pos1, _heap.set(pos2, _heap.get(pos1)));
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main(String[] args) {
        ALMaxHeap pile = new ALMaxHeap();
        pile.add(2);
        System.out.println(pile);
        pile.add(4);
        System.out.println(pile);
        pile.add(6);
        System.out.println(pile);
        pile.add(8);
        System.out.println(pile);
        pile.add(10);
        System.out.println(pile);
        pile.add(1);
        System.out.println(pile);
        pile.add(3);
        System.out.println(pile);
        pile.add(5);
        System.out.println(pile);
        pile.add(7);
        System.out.println(pile);
        pile.add(9);
        System.out.println(pile);

        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMax() + "...");
        System.out.println(pile);
    }//end main()

}//end class ALMaxHeap
