package tree;

 class Node<T extends Comparable <? super T>> {
    
    private T data; 
    private Node<T> left;
    private Node<T> right;
    
    /**
     * Constructs a BSTNode with the given data
     * 
     * @param data
     */
    Node (T data) { this.data = data; }

    /**
     * Gets the data
     * @return the data
     */

    T getData(){ return data; }

    /**
     * Gets the left child
     * 
     * @return the left child
     */
    Node<T> getLeftNode() { return left; }

    /**
     * Gets the right child
     * 
     * @return the right child
     */
    Node<T> getRightNode() { return right; }
    
    /**
     * Sets the data
     * 
     * @param data
     */
    void setData(T data) { this.data = data;}

    void setLeft(Node<T> left) { this.left = left; }

    void setRight(Node<T> right) { this.right = right; }

    @Override 
    public String toString() { return "Node containing: " + data; }

}
