package Array_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class A56_Merge_Intervals {
    /*
    题目：合并区间
    思路：区间问题，就是线段问题。让你合并所有线段、找出线段的交集等等。主要有两个方法：
        1、排序。常见的排序方法就是按照区间起点排序，或者先按照起点升序排序，若起点相同，则按照终点降序排序。
        2、画图。两个区间的相对位置到底有几种可能，分情况讨论。
    方法：先按照区间起点排序，保证区间起点是递增的，方便后续操作。
         然后画图，找出两个区间相交or不相交的所有情况，再分情况讨论。
    详见：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487316&idx=1&sn=95cfbbd24f1cb5d8c07c71c2ba15246a&scene=21#wechat_redirect
    */
    public int[][] merge(int[][] intervals) {
        // 1.先按照区间起点排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        // 2.分情况讨论 两个区间相交or不相交的所有情况
        ArrayList<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(cur[1] >= intervals[i][1]){
                continue;
            }else if(cur[1] < intervals[i][1] && cur[1] >= intervals[i][0]){
                cur[1] = intervals[i][1];
            }else if(cur[1] < intervals[i][0]){
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);

        // 注意ArrayList.toArray()返回的是Object[]
        // 要想让其返回想要的类型，那就新建一个当作传入参数。
        int[][] r = new int[res.size()][2];
        res.toArray(r);
        return r;
    }


    // for test
    public static void main(String[] args){
        A56_Merge_Intervals t = new A56_Merge_Intervals();
        int[][] ta = {{1,3}, {15,18}, {8,10}, {2,6}};
        int[][] res = t.merge(ta);
        for(int i = 0; i < res.length; i++){
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
        }

    }
}
