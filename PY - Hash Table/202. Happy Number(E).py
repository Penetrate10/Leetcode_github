def isHappy(self, n: int) -> bool:
    """
    题目：快乐数【循环计算】
    方法：
        方法1：审题“loops endlessly in a cycle” => 有重复 => 判断一个元素是否出现在集合里 => HashTable
        方法2：由于不是快乐数就会循环，循环就是环结构。
              而且快乐数的计算方法与链表的结构很相似，前一个连着后一个。
              所以可以参考Floyd's Cycle-Finding Algorithm（141. Linked List Cycle），
              使用双指针（slow/fast runners）。
    语法：嵌套函数（见方法2代码）
    """

    # 方法1：HashTable
    sums = []
    while n != 1:
        sum = 0
        while n > 0:
            sum += (n % 10) ** 2
            n = n // 10
        if sum == 1:
            return True
        else:
            if sum in sums:
                return False
            else:
                sums.append(sum)
                n = sum
    return True

    # 方法2：双指针（slow/fast runners）
    '''
    def get_next(number):
        """
        嵌套函数：
        1. 嵌套函数（内部函数）能访问外部函数的变量，但不能修改。（列表，集合是容器变量，可以修改）
            想要修改需使用nonlocal，如“nonlocal x”
        2. 注意要先写出嵌套函数（内部函数），才能在外部函数中调用，顺序不能反过来，与一个类里多个函数不同。
        3. 嵌套函数（内部函数）无需self
        """
        total_sum = 0
        while number > 0:
            number, digit = divmod(number, 10)
            total_sum += digit ** 2
        return total_sum

    slow_runner = n
    fast_runner = get_next(n)
    while fast_runner != 1 and slow_runner != fast_runner:
        slow_runner = get_next(slow_runner)
        fast_runner = get_next(get_next(fast_runner))
    return fast_runner == 1
    '''
