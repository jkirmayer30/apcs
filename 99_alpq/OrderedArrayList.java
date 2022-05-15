
import java.util.ArrayList;

public class OrderedArrayList{
    private ArrayList<Integer> _data;

    public OrderedArrayList() {
        //O(1)
        _data = new ArrayList<Integer>();
    }

    public void add(int value) {
        //O(n)
        int idx = Utils.binarySearchInsert(_data, value);
        System.out.println(idx);
        _data.add(idx, value);
    }

    public Integer remove() {
        //O(1)
        return _data.remove(_data.size()-1);
    }

    public Integer get() {
        //O(1)
        return _data.get(_data.size()-1);
    }

    public int size() {
        //O(1)
        return _data.size();
    }

    public String toString() {
        //O(n)
        String retStr = "[";
        for (int i = 0; i < _data.size(); i++) {
            retStr += _data.get(i);
            if (i != _data.size() - 1)
                retStr += ", ";
        }
        retStr += "]";
        return retStr;
    }

}
