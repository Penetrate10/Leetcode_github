package Array_String.Two_Pointers.LeftRight_Pointers;

public class A11_Container_With_Most_Water {
    /*
    题目：找盛水的最大容器
    思路：双指针
        1. 明确3个事实：
          (1)短板的高度越高，容积越大；宽度（两杆间距）越大，容积越大。
          (2)短板已发挥出全部实力，没有潜力可以挖掘了。所以如果指针移动（宽度减小），那么只有移动指向短板的指针，容积才有可能增大。
          (3)如果你去移动较高的那一边，矩形的高度是无论如何都不会变大的，所以不可能使矩形的面积变得更大。
             如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，进而就「有可能」使得矩形的面积变大。
        2. 左右双指针：
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
