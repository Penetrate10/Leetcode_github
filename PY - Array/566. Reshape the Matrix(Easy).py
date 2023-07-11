def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
    '''
    题目：改变矩阵维度

    矩阵可以仅使用一个指针来遍历：
    令 index = 0，
        matrix[int(index / 列数)][index % 列数]
        index += 1
    '''
    res = []
    m = len(mat)
    n = len(mat[0])
    if m * n != r * c:
        return mat

    index = 0
    for i in range(r):
        row = []
        for j in range(c):
            row.append(mat[int(index / n)][index % n])
            index += 1
        res.append(row)

    return res