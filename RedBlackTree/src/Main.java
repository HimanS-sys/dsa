class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    boolean color; // false: red, true: black

    public Node(int data) {
        this.data = data;
    }
}
class RedBlackTree {
    Node node;
    public Node rightRotate(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if(leftChild.right!= null) {
            leftChild.right.parent = node;
        }
        node.parent = leftChild;
        replaceParentsChild(parent, node, leftChild);
        return leftChild;
    }
    public Node leftRotate(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;
        //Node leftRight = left.right;
        node.right = rightChild.left;
        if(rightChild.left!= null) {
            rightChild.left.parent = node;
        }
        node.parent = rightChild;
        replaceParentsChild(parent, node, rightChild);
        return rightChild;
    }

    public void replaceParentsChild(Node parent, Node node, Node childNode) {

    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}