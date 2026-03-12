package tree;

import java.util.Collection;

/** Remember Search, add, remove time complexity is Olog(N)
*/ 

public class BinarySearchTree<T extends Comparable < ? super T>> {
    private Node<T> rootNode;
    private int size;

    public BinarySearchTree() {
    }

    /**
     * Guide  Not all Collectionss are 
     * indexable like but all collections are Iterable
     * 
     * -> using enhance loop
     * */
    public BinarySearchTree(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("the passed in data is null");
        }
        for (T elements : data) {
            if (elements == null) {
                throw new IllegalArgumentException();
            }
            //add method goes here.
            add(elements);
        }
        
   }
 /**
 * require to use recursive to do the add method
 * 
 * @param elements
 */
    public void add(T elements) {
       rootNode = recursiveAdd(rootNode,elements);
    }

    private Node<T> recursiveAdd(Node<T> rootNode, T elements) {
    // situation where the tree is empty and we add the first node
    if(rootNode == null) {
        size++;
        //basically we just set the root to the elements
        Node<T> node = new Node<>(elements);
        return node;
    }
    //situation where the tree is not empty and we have to add to left or right
    if (elements.compareTo(rootNode.getData()) < 0) {
        rootNode.setLeft(recursiveAdd(rootNode.getLeftNode(), elements));
    }
    if (elements.compareTo(rootNode.getData()) > 0) {
        rootNode.setRight(recursiveAdd(rootNode.getRightNode(), elements));
    }
    return rootNode;
 }

 /**
  * for remove do both predecessor and successor
  * have to be recursively
  */
    public T remove(T element) {
        Node<T> temp = new Node<>(null);
        rootNode =   recursiveRemove(element, rootNode, temp);
        return temp.getData();
    }

 private Node<T> recursiveRemove(T element, Node<T> rootNode, Node<T> temp) {
    if (rootNode == null) {
        return null;
    } else if (element.compareTo(rootNode.getData()) < 0) {
        rootNode.setLeft(recursiveRemove(element, rootNode.getLeftNode(), temp));
    } else if (element.compareTo(rootNode.getData()) > 0) {
        rootNode.setRight(recursiveRemove(element, rootNode.getRightNode(), temp));
    } else {
        temp.setData(rootNode.getData());
        size--;

        if (rootNode.getLeftNode() == null && rootNode.getRightNode() == null) {

            return null;

        } else if (rootNode.getLeftNode() == null) {

            return rootNode.getRightNode();

        } else if (rootNode.getRightNode() == null) {

            return rootNode.getLeftNode();

        } else {
            Node<T> secondTemp = new Node<>(null);
            //if use predecessor
            rootNode.setLeft(predecessor(rootNode.getLeftNode(),secondTemp));
            rootNode.setData(secondTemp.getData());
        }
    }
 }

 private Node<T> predecessor(Node<T> leftNode, Node<T> secondTemp) {
    if (leftNode.getRightNode() == null) {
        secondTemp.setData(leftNode.getData());
        return leftNode.getLeftNode();
    } else {
        leftNode.setRight(predecessor(leftNode.getRightNode(), secondTemp));
    }
    return leftNode;
 }









}
