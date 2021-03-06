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
        if (stRoot.getLeft()!=null){
            retVal = height(stRoot.getLeft());
        }
        if (stRoot.getRight()!=null){
            int rightHeight = height(stRoot.getRight());
            if (rightHeight>retVal){
                retVal += rightHeight;
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

    //main method for testing
    public static void main(String[] args) {

        BST arbol = new BST();

        //PROTIP: sketch state of tree after each insertion
        //        ...BEFORE executing these.
        arbol.insert(4);
        arbol.insert(2);
        arbol.insert(5);
        arbol.insert(6);
        arbol.insert(1);
        arbol.insert(3);

        System.out.println("\n-----------------------------");
        System.out.println("pre-order traversal:");
        arbol.preOrderTrav();

        System.out.println("\n-----------------------------");
        System.out.println("in-order traversal:");
        arbol.inOrderTrav();

        System.out.println("\n-----------------------------");
        System.out.println("post-order traversal:");
        arbol.postOrderTrav();

        System.out.println("\n-----------------------------");
        System.out.println("\n-----------------------------");
        System.out.println("search:");
        System.out.println(arbol.search(4).getValue());
        System.out.println(arbol.search(9));
        System.out.println("\n-----------------------------");

        System.out.println("\n-----------------------------");
        System.out.println("height:");
        System.out.println(arbol.height());
        System.out.println("\n-----------------------------");

        System.out.println("\n-----------------------------");
        System.out.println("leaves:");
        System.out.println(arbol.numLeaves());
        System.out.println("\n-----------------------------");
    }

}//end class
