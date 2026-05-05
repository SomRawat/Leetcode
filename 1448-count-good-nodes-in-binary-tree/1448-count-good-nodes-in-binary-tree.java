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

    public int goodNodes(TreeNode root) {
        return countGood(root, Integer.MIN_VALUE);
    }

    private int countGood(TreeNode node, int maxSoFar) {

        if (node == null) return 0;

        int isGood = node.val >= maxSoFar ? 1 : 0;

        int newMax = Math.max(maxSoFar, node.val);

        return isGood 
             + countGood(node.left, newMax) 
             + countGood(node.right, newMax);
    }
}