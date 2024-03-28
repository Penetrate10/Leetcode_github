package Array_String.Two_Pointers.LeftRight_Pointers.Binary_Search;

public class A74_Search_a_2D_Matrix {
    /*
    题目：遍历有序二维矩阵
    思路：矩阵整体是非严格单调递增的。出现单调就可以考虑二分搜索。
         二维矩阵可以转化为一维矩阵，其在一位矩阵中的坐标可表示为
         index = i * n + j
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if(matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                left = mid + 1;
            } else if (matrix[i][j] > target){
                right = mid - 1;
            }
        }

        return false;
    }
}
