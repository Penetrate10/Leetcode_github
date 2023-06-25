package Two_Pointers;

public class TP11_Container_With_Most_Water {
    /*
    题目：找盛水的最大容器
    思路：双指针
        1. 明确3个事实：
          (1)短板的高度越高，容积越大；宽度（两杆间距）越大，容积越大
          (2)短板已发挥出全部实力，没有潜力可以挖掘了。所以如果指针移动（宽度减小），那么只有移动指向短板的指针，容积才有可能增大。
          (3)杆子在被丢弃时，已发挥出最大实力。因为高度已全部使用，且宽度即便给到最宽，其容积也一定不如当前最大值大。
            证明一个例子：在example 1中，为什么（杆子1，杆子8）一定小于当前最大值（杆子2，9）呢？算法只比较了（2，8）一定小于（2，9）。
            因为（1，8）< （1，9）<（2，8）。所以被丢弃的杆子无需再次使用。
        2. 前后双指针：
            向中间移动，哪侧杆子高度小就移动哪一侧的指针。每移动一下，就比较一下当前最大值。
    时间复杂度: O(n)
    */
    public int maxArea(int[] height) {
        int right = height.length-1;
        int left = 0;
        int most_water = 0;
        int water = 0;
        while(left != right){
            if(height[left] >= height[right]){
                water = (right-left)*height[right];
                right--;
            }else{
                water = (right-left)*height[left];
                left++;
            }
            if(water > most_water)
                most_water = water;
        }
        return most_water;
    }
}
