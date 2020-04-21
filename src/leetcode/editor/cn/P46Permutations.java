//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * result = []
         * def backtrack(路径, 选择列表):
         *     if 满足结束条件:
         *         result.add(路径)
         *         return
         *
         *     for 选择 in 选择列表:
         *         做选择
         *         backtrack(路径, 选择列表)
         *         撤销选择
         */

        public List<List<Integer>> permute1(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            backtrack(res, list, nums);
            return res;
        }

        private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int num : nums) {
                if (!list.contains(num)) {
                    list.add(num);//做选择
                    backtrack(res, list, nums);
                    list.remove(list.size() - 1);//撤销选择
                }
            }
        }


        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            dfs(nums, 0);
            return res;
        }

        private void dfs(int[] nums, int cur) {
            if (nums.length == cur) {
                List<Integer> line = new ArrayList<>();
                for (int num : nums) {
                    line.add(num);
                }
                res.add(line);
            }else {
                for (int i = cur; i < nums.length; i++) {
                    swap(nums, i, cur);//把每一个数都放在第一位一次
                    dfs(nums, cur + 1);//后面的元素做全摆列
                    swap(nums, i, cur);//防止重复元素
                }
            }
        }

        private void swap(int[] nums, int i, int cur) {
            int temp = nums[i];
            nums[i] = nums[cur];
            nums[cur] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}