//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//java:二叉树的前序遍历
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal1(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            helper(root, list);
            return list;
        }

        private void helper(TreeNode root, ArrayList<Integer> list) {
            if (root != null) {
                list.add(root.val);
                if (root.left != null) {
                    helper(root.left, list);
                }
                if (root.right != null) {
                    helper(root.right, list);
                }
            }
        }
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while(curr != null || !stack.isEmpty()){
                while (curr != null) {
                    list.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                curr = curr.right;
            }
            return list;
        }
        public List<Integer> preorderTraversal2(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}