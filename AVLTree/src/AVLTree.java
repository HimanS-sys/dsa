public class AVLTree {
    public static class Node {
        int value;

        int height;

        Node left;

        Node right;

        Node(int val) {
            this.value = val;
            this.height = 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("asfa");
    }
    // node = 1, val = 8
    // node = 5, val = 8
    // node = null, val = 8

    static Node insert(Node node, int val) {
        if(node == null) {
            return new Node(val);
        } else if(node.value > val) {
            node.left = insert(node.left, val);
            // 5 < 8
        } else if(node.value < val) {
            node.right = insert(node.right, val);
        } else {
            return node;
        }
        // node = 1, height = 2 -> 3
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node); // node = 1, balance = -2
        if(balance > 1 && val < node.left.value) {
            return rightRotate(node);
        } else if (balance < -1 && val > node.right.value) {
            return leftRotate(node);
        } else if (balance > 1 && val > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if(balance < -1 && val < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    static int getBalance(Node node) {
        if(node == null) {
            return 0;
        }
        return (getHeight(node.left) - getHeight(node.right));
    }

    static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }
    // node = 1, L = null, R = 5
    /*
    1
     \
      5
       \
        8
    */
    static Node leftRotate(Node node) {
        Node right = node.right; // right = 5
        node.right = right.left; // node.right = null
        right.left = node; // right.left = 1

        /*
             5(2)
            /    \
           1(1)  8(1)
           \
            null(0)
        */
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
        return right;
    }
    static Node rightRotate(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
        return left;
    }
}
