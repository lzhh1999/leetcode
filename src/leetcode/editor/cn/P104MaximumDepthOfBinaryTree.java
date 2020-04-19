//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//java:二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left = maxDepth1(root.left);
                int right = maxDepth1(root.right);
                return Math.max(left, right) + 1;
            }
        }

        public int maxDepth2(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int preCount = 1;
            int pCount = 0;
            int level = 0;
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                preCount--;
                if (temp.left != null) {
                    queue.offer(temp.left);
                    pCount++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    pCount++;
                }
                if (preCount == 0) {
                    preCount = pCount;
                    pCount = 0;
                    level++;
                }
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}