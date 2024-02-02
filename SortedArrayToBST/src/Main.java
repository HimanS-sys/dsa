public class Main
{
    public static void main(String[] args)
    {
        // custom sorted int array
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        // convert sorted array to binary search tree
        TreeNode root = BST(nums, 0, nums.length - 1);
        // print elements of bst
        print2DUtil(root, 10);

    }

    static TreeNode BST(int[] nums, int start, int end)
    {
        if(start == end) {
            return new TreeNode(nums[start]);
        } else if(start > end) {
            return null;
        }
        int val = (start + end)/2;
        TreeNode root = new TreeNode(nums[val]);
        root.left = BST(nums, start, val - 1);
        root.right = BST(nums, val + 1, end);

        return root;
    }
    static void print2DUtil(TreeNode root, int space)
    {
        // base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 5;

        // process right child first
        print2DUtil(root.right, space);

        // print current node after space
        // count
        System.out.print("\n");
        for (int i = 5; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // process left child
        print2DUtil(root.left, space);
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}