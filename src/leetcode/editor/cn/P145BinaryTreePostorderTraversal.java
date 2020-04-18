//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn;

import java.util.*;

//java:二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal1(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.addFirst(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            return output;
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            helper(root, list);
            return list;
        }

        private void helper(TreeNode root, ArrayList<Integer> list) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, list);
                }
                if (root.right != null) {
                    helper(root.right, list);
                }
                list.add(root.val);
            }
        }

        public List<Integer> postorderTraversal2(TreeNode root) {
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
            Collections.reverse(list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}