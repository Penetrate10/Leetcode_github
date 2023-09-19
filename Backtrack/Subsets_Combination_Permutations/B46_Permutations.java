package Backtrack.Subsets_Combination_Permutations;

import java.util.ArrayList;
import java.util.List;

public class B46_Permutations {
    /*
    题目：元素无重不可复选的 排列问题
    思路：见 子集&组合&排列问题.md
         详见：https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-56e11/
    */
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            track.remove(track.size()-1);
            used[i] = false;
        }
    }
}
