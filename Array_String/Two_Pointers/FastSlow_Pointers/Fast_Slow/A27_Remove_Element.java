package Array_String.Two_Pointers.FastSlow_Pointers.Fast_Slow;

public class A27_Remove_Element {
    /*
    题目：移除元素
    思路：经典快慢双指针
         结合26题，总结：
            1. fast指针只是一个探头，用来比较大小，判断fast指向的值是否满足题目条件。具体与slow指向的值比较，还是与其他值比较，可根据题意变换。
               slow指针才是指向真正要被替换的元素（slow或slow后面那个元素），这是因为slow指针保证了[0,slow]是满足题目条件的（根据题意也可以是或[0,slow)）。
               slow和fast维护的数组区间示意图：
               [---------- slow ------------—-- fast ---]
               [满足题目条件  ｜  已检查,不满足条件   ｜  未检查]

            2. 具体来说，如果fast处的值不满足条件，就用fast的值覆盖slow的值（根据题意也可以是slow后面那个元素），slow和fast都前进一步；
            如果fast处的值满足条件，只有fast前进一步，slow不动。
    */
    public int removeElement(int[] nums, int val) {
        // 处理特殊情况
        if(nums.length == 0) return 0;

        // 快慢双指针
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            // 不满足条件，替换slow的值
            if(nums[fast] != val){  // fast是一个探头，用来比较大小，判断是否满足条件
                nums[slow] = nums[fast];  // slow才是真正要被替换值的
                slow++;  // 移动slow指针
            }
            // 满足条件，只移动fast
            fast++;
        }
        return slow;
    }
}
