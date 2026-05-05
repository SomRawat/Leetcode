/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int kthSmallest(TreeNode root, int k) {

        TreeNode current = root;

        while (current != null) {

            // Case 1: No left subtree
            if (current.left == null) {

                k--;
                if (k == 0) return current.val;

                current = current.right;
            } 
            else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Case 2: Create thread
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } 
                else {
                    // Case 3: Remove thread
                    predecessor.right = null;

                    k--;
                    if (k == 0) return current.val;

                    current = current.right;
                }
            }
        }

        return -1;
    }
}