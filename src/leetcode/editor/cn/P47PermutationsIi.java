//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.*;

//java:全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<List<Integer>> set = new HashSet<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            dfs(nums, 0);
            List<List<Integer>> ans = new ArrayList<>(set);
            return ans;
        }

        private void dfs(int[] nums, int cur) {
            if (cur == nums.length) {
                List<Integer> line = new ArrayList<>();
                for (int i : nums) {
                    line.add(i);
                }
                set.add(line);
            }else{
                for (int i = cur; i < nums.length; i++) {
                    swap(nums, cur, i);
                    dfs(nums, cur + 1);
                    swap(nums,cur, i);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}