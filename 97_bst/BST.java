import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 * <p>
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 * and any value in its right subtree must be greater.)
 * <p>
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST {

    //instance variables / attributes of a BST:
    TreeNode _root;
    /**
     * default constructor
     */
    BST() {
        _root = null;
    }


    /**
     * void insert( int )
     * Adds a new data element to tree.
     */
    public void insert(int newVal) {
        TreeNode newNode = new TreeNode(newVal);
        if (_root == null) {
            _root = newNode;
        } else {
            insert(_root, newNode);
        }
    }

    //recursive helper for insert(int)
    public void insert(TreeNode stRoot, TreeNode newNode) {
        if (newNode.getValue() > stRoot.getValue()) {
            if (stRoot.getRight() != null) {
                insert(stRoot.getRight(), newNode);
            } else {
                stRoot.setRight(newNode);
            }
        } else {
            if (stRoot.getLeft() != null) {
                insert(stRoot.getLeft(), newNode);
            } else {
                stRoot.setLeft(newNode);
            }
        }
    }//end insert()


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav() {
        preOrderTrav(_root);
    }

    public void preOrderTrav(TreeNode currNode) {
        System.out.println(currNode.getValue());
        if (currNode.getLeft() != null) {
            preOrderTrav(currNode.getLeft());
        }
        if (currNode.getRight() != null) {
            preOrderTrav(currNode.getRight());
        }
    }

    //recurse left, process root, recurse right
    public void inOrderTrav() {
        inOrderTrav(_root);
    }

    public void inOrderTrav(TreeNode currNode) {
        if (currNode.getLeft() != null) {
            inOrderTrav(currNode.getLeft());
        }
        System.out.println(currNode.getValue());
        if (currNode.getRight() != null) {
            inOrderTrav(currNode.getRight());
        }
    }

    //recurse left, recurse right, process root
    public void postOrderTrav() {
        postOrderTrav(_root);
    }

    public void postOrderTrav(TreeNode currNode) {
        if (currNode.getLeft() != null) {
            postOrderTrav(currNode.getLeft());
        }
        if (currNode.getRight() != null) {
            postOrderTrav(currNode.getRight());
        }
        System.out.println(currNode.getValue());
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search(int target) {
        return search(target, _root);
    }

    TreeNode search(int target, TreeNode stRoot) {
        if (stRoot.getValue() > target) {
            if (stRoot.getLeft() != null) {
                return search(target, stRoot.getLeft());
            } else {
                return null;
            }
        } else if (stRoot.getValue() == target) {
            return stRoot;
        } else {
            if (stRoot.getRight() != null) {
                return search(target, stRoot.getRight());
            } else {
                return null;
            }
        }
    }

    TreeNode findParent(int target, TreeNode stRoot) {
        if (stRoot.getLeft().getValue() == target||stRoot.getRight().getValue() == target) {
            return stRoot;
        } else if (stRoot.getValue() > target) {
            if (stRoot.getLeft() != null) {
                return search(target, stRoot.getLeft());
            } else {
                return null;
            }
        }else {
            if (stRoot.getRight() != null) {
                return findParent(target, stRoot.getRight());
            } else {
                return null;
            }
        }
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height() {
        return height(_root);
    }

    int height(TreeNode stRoot) {
        int retVal = 0;
        if (stRoot==null){
            return 0;
        }
        if (stRoot.getLeft()!=null){
            retVal = height(stRoot.getLeft());
        }
        if (stRoot.getRight()!=null){
            int rightHeight = height(stRoot.getRight());
            if (rightHeight>retVal){
                retVal = rightHeight;
            }
        }
        return retVal+1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves() {
        return numLeaves(_root);
    }

    int numLeaves(TreeNode stRoot){
        int retVal = 0;
        if (stRoot.getLeft()!=null)
            retVal+=numLeaves(stRoot.getLeft());
        if (stRoot.getRight()!=null)
            retVal+=numLeaves(stRoot.getRight());
        if (retVal == 0)
            return 1;
        else
            return retVal;
    }

    int greatestVal(TreeNode stRoot){
        if (stRoot.getRight()==null)
            return stRoot.getValue();
        else
            return greatestVal(stRoot.getRight());
    }

    int leastVal(TreeNode stRoot){
        if (stRoot.getLeft()==null){
            return stRoot.getValue();
        }
        else{
            return leastVal(stRoot.getLeft());
        }
    }

    public String toString(){
        if (_root==null)
            return "";
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(_root);
        int least = leastVal(_root);
        int great = greatestVal(_root);
        int leastLength = 1;
        int greatLength = 1;
        if (least<0) {
            leastLength = (int) Math.log10(-1*least)+2;
        }
        if (great>0) {
            greatLength = (int) Math.log10(great)+1;
        }
        return toString(q,1,this.height(),Math.max(leastLength,greatLength));
    }

    int findReplaceReturn(TreeNode stRoot,boolean rootGettingRemoved){
        if (rootGettingRemoved){
            if (stRoot.getLeft().getRight()==null){
                int val =stRoot.getLeft().getValue();
                stRoot.setLeft(stRoot.getLeft().getLeft());
                return val;
            } else {return findReplaceReturn(stRoot.getLeft(),false);}
        } else {
            if (stRoot.getRight().getRight()==null){
                int val =stRoot.getRight().getValue();
                stRoot.setRight(stRoot.getRight().getLeft());
                return val;
            } else {return findReplaceReturn(stRoot.getRight(),false);}
        }
    }

    public void remove(int num){
        TreeNode thisNode = search(num);
        if (num==_root.getValue()&&_root.getLeft()==null&&_root.getRight()==null){
            _root=null;
            return;
        }
        if(thisNode.getLeft()==null){
            if (thisNode.getRight()!=null) {
                thisNode.setValue(thisNode.getRight().getValue());
                thisNode.setLeft(thisNode.getRight().getLeft());
                thisNode.setRight(thisNode.getRight().getRight());
            } else {
                TreeNode dad = findParent(num,_root);
                if (dad.getLeft()!=null&&dad.getLeft().getValue()==num){
                    dad.setLeft(null);
                } else {dad.setRight(null);}
            }
        } else if(thisNode.getRight()==null) {
            if (thisNode.getLeft()!=null) {
                thisNode.setValue(thisNode.getLeft().getValue());
                thisNode.setRight(thisNode.getLeft().getRight());
                thisNode.setLeft(thisNode.getLeft().getLeft());
            }
        } else {
            int value = findReplaceReturn(thisNode,true);
            thisNode.setValue(value);
        }
    }

    String replace(String toModify,String newString,int startIdx){
        return toModify.substring(0,startIdx)+newString+toModify.substring(startIdx+newString.length());
    }

    String toString(LinkedList<TreeNode> printQueue,int layerNum,int height,int maxStrLength){
        if (height==0){return "";}
        int printLen = printQueue.size();
        int initialSpace = ((int) Math.pow(2,height-layerNum)-1);
        String thisLayer = "";
        String connectNext = "";
        for (int sp = 0;sp<initialSpace*((int) Math.pow(2,maxStrLength-1));sp++) {
            thisLayer += " ";
        }
        for (int sp = 0;sp<((int) Math.pow(2,height)-1)*((int) Math.pow(2,maxStrLength-1));sp++) {
            connectNext += " ";
        }
        for (int i = 0; i<printLen;i++){
            TreeNode item = printQueue.removeFirst();
            int def = maxStrLength;
            if (item ==null){
                printQueue.addLast(null);
                printQueue.addLast(null);
            } else {
                thisLayer+=item.getValue();
                int len;
                if (item.getValue()<0) {
                    len = (int) Math.log10(-1*item.getValue())+2;
                }else if  (item.getValue()>0) {
                    len = (int) Math.log10(item.getValue())+1;
                }else {len = 1;}
                def = maxStrLength-len;
                String newString = "";
                int linkLen = ((int) Math.pow(2,height-layerNum-1)-1)*((int) Math.pow(2,maxStrLength-1));
                for (int sp = 0;sp<linkLen;sp++)
                    newString+="-";
                printQueue.addLast(item.getLeft());
                if (item.getLeft()!=null) {
                    connectNext = replace(connectNext, "/" + newString, thisLayer.length()-linkLen-2);
                }
                printQueue.addLast(item.getRight());
                if (item.getRight()!=null) {
                    connectNext = replace(connectNext,  newString+"\\", thisLayer.length());
                }
            }
            for (int sp = 0;sp<def+((2*initialSpace+1)*((int) Math.pow(2,maxStrLength-1)));sp++)
                thisLayer+=" ";
        }
        if (layerNum==height){return thisLayer;}
        else {
            return thisLayer+"\n"+connectNext+"\n"+toString(printQueue,layerNum+1,height,maxStrLength);
        }
    }


    //main method for testing
    public static void main(String[] args) {

        BST arbol = new BST();
        System.out.println( "tree init'd: " + arbol );
        //inserting in this order will build a perfect tree
        arbol.insert( 3 );
        arbol.insert( 1 );
        arbol.insert( 0 );
        arbol.insert( 2 );
        arbol.insert( 5 );
        arbol.insert( 4 );
        arbol.insert( 6 );
        arbol.insert(-2);
        arbol.insert(9);
        arbol.insert(7);

        //insering in this order will build a linked list to left

//	arbol.insert( 6 );
//	arbol.insert( 5 );
//	arbol.insert( 3 );
//	arbol.insert( 4 );
//	arbol.insert( 2 );
//	arbol.insert( 1 );
//	arbol.insert( 0 );


        System.out.println("height");
        System.out.println(arbol.height());
        System.out.println("height");

        System.out.println( "tree after insertions:\n" + arbol );
        System.out.println();

        System.out.println();
        for( int i=-1; i<8; i++ ) {
            System.out.println(" searching for "+i+": " + arbol.search(i) );
        }

        System.out.println();
        System.out.println( arbol );

        arbol.remove(6);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(5);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(4);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(3);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(2);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(1);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(0);
        System.out.println();
        System.out.println( arbol );
    }

}//end class
