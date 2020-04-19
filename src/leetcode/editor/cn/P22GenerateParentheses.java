//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");
            return list;
        }

        private void dfs(int left, int right, String s) {
            if (left == 0 && right == 0) {// 左右括号都不剩余了，递归终止
                list.add(s);
                return;
            }
            if (left > 0) {// 如果左括号还剩余的话，可以拼接左括号
                dfs(left - 1, right, s + "(");
            }
            if (right > left) {// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
                dfs(left, right - 1, s + ")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}