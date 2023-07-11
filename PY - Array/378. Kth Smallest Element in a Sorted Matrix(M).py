import heapq

def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    '''
    题目：有序矩阵的 第k小元素
    方法：Heapq小根堆：
        由于每一行内部都是sorted，但每一行之间没有大小关系，
        所以要在每一行的最小值中寻找最小值，直到找到第k小。
        （如果只有两行，类似双指针的思路，一行一个指针，
          这里的小根堆使得我们不用存这些指针，
          而是把指针和每行的最小值作为list，直接放入heap中即可）
    语法：1. import heapq，这个heapq就是小根堆，有现成的函数可用。
            注意：heapq中的元素可以是列表或元组，
                 heapq按照每个元素的第一个元素来排序。
                 若有元素的第一个元素相同，
                 则在这些元素之间，按照其第二个元素来排序，依此类推。
         2. 列表解析式可以生成列表：
            [i*2 for i in range(1, 5)]
            >>> [2, 4, 6, 8]
            [i*2 for i in range(1, 5) if i%2==0]
            >>> [4, 8]
    '''

    minHeap = [[matrix[row][0], row, 0] for row in range(len(matrix))]

    heapq.heapify(minHeap)
    for i in range(k - 1):
        value, row, col = heapq.heappop(minHeap)
        col += 1
        if col < len(matrix[0]):
            heapq.heappush(minHeap, [matrix[row][col], row, col])

    value, row, col = heapq.heappop(minHeap)
    return value
