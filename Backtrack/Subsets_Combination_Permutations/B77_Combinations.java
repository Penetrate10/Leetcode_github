package Backtrack.Subsets_Combination_Permutations;

import java.util.ArrayList;
import java.util.List;

public class B77_Combinations {
    /*
    题目：元素无重不可复选的 组合问题
    思路：见 子集&组合&排列问题.md
         详见：https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-56e11/
    */
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    void backtrack(int n, int k, int start) {
        if(track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i+1);
            track.remove(track.size()-1);
        }
    }
}
