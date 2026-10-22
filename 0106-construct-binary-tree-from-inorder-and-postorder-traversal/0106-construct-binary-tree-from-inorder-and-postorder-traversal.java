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
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return construct(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootValue = postorder[postIdx];
        postIdx--;

        TreeNode rootNode = new TreeNode(rootValue);

        int inordIdx = left;
        while(inorder[inordIdx] != rootValue){
            inordIdx++;
        }
        rootNode.right= construct(inorder, postorder, inordIdx+1, right);
        rootNode.left = construct(inorder, postorder,left, inordIdx-1);

        return rootNode;
    }
}