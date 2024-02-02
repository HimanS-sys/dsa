import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depthCounterLeft = maxDepth(root.left);
        int depthCounterRight = maxDepth(root.right);
        return Math.max(depthCounterLeft, depthCounterRight) + 1;
    }
    public static void main(String[] args) {
        Integer[] treeArr = new Integer[]{3, 9, 20, null, null, 15, 7};
        Queue<TreeNode> rootQueue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(treeArr[0]);
        rootQueue.add(root);
        int count = 1;
        while(count < treeArr.length && !rootQueue.isEmpty()) {
            TreeNode curr = rootQueue.remove();
            if(count < treeArr.length) {
                if(treeArr[count]!=null) {
                    curr.left = new TreeNode(treeArr[count++]);
                    rootQueue.add(curr.left);
                } else {
                    count++;
                }
            }
            if(count < treeArr.length) {
                if(treeArr[count]!=null) {
                    curr.right = new TreeNode(treeArr[count++]);
                    rootQueue.add(curr.right);
                } else {
                    count++;
                }
            }
        }
        int depth = maxDepth(root);
        System.out.println("The max depth is: " + depth);
    }
}