package Backtrack.Subsets_Combination_Permutations;

import java.util.ArrayList;
import java.util.List;

public class B78_Subsets {
    /*
    题目：元素无重不可复选的子集问题
    思路：见 子集&组合&排列问题.md
         详见：https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-56e11/
    */
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track =  new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        res.add(new ArrayList<Integer>(track));

        for(int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.remove(track.size()-1);
        }
    }
}
