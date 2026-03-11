import java.util.Scanner;

class Tree{

    public Tree(){

    }

    private class Node {
        private int value;
        Node lNode;
        Node rNode;

        public Node(int value) {
            this.value = value;
        }


    }

    private Node rootNode;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node");
        int  value = scanner.nextInt();
        rootNode = new Node(value);
        populate(scanner, rootNode);
    }


    private void populate(Scanner scanner,Node node) {
       System.out.println("Do you want to enter left of " + node.value);
       boolean left = scanner.nextBoolean();
       if(left) {
        System.out.println("Enter the value of the left of " + node.value);

       }
    }


    // insert elements
    public void insert(int value) {

    }

}