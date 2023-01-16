def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    '''
    题目：有序矩阵查找
    方法：矩阵的双指针法：
        1. 观察得出 一个数的右方、下方、右下方均 > 这个数，一个数的左方、上方、左上方均 < 这个数。
        2. 所以如果目标值tar < 当前值cur, 需要将指针向左/上移动；
              如果目标值tar > 当前值cur, 需要将指针向右/下移动。
        3. 一个指针row指向当前值的行数，一个指针col指向当前值的列数。
        4. 由2可得，“当前值”的起始点应为矩阵的右上角/左下角。
            以从右上角开始为例：目标值tar < 当前值cur时，指针向左移动；
                             目标值tar > 当前值cur时，指针向下移动。
            以从左上角开始为例：目标值tar < 当前值cur时，指针向上（或左）移动；
                             目标值tar > 当前值cur时， 指针向下（或右）移动。
                            这样会导致当前值在第一行/第一列中陷入死循环，故无法从左上角开始。
        5. 重复4直到找到target，或走到了 第一列/最后一行 还没找到。
    '''
    row = 0
    col = len(matrix[0]) - 1
    while row < len(matrix) and col >= 0:
        cur = matrix[row][col]
        if target > cur:
            row += 1
        elif target < cur:
            col -= 1
        else:
            return True
    return False
