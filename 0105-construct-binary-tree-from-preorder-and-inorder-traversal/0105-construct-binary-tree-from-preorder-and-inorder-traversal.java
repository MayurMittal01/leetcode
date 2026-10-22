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
    int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        return construct(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[preIdx];
        preIdx++;

        TreeNode rootNode = new TreeNode(rootValue);

        int inordIdx = left;
        while (inorder[inordIdx] != rootValue) {
            inordIdx++;
        }
        rootNode.left = construct(preorder, inorder, left, inordIdx - 1);
        rootNode.right = construct(preorder, inorder, inordIdx + 1, right);

        return rootNode;
    }
}