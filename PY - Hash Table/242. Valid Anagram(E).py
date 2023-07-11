def isAnagram(self, s: str, t: str) -> bool:
    """
    题目：判断两个字符串的元素是否相同，不考虑顺序

    方法1：HashMap来计数

    方法2：collections.defaultdict
          在defaultdict(int)中，如果i不在defaultdict中，defaultdict[i]返回0

    方法3：collections.Counter
          Counter()返回一个dict，里面是每个元素的个数
    """

    # 方法1.1：计数先增后减，只使用1个hashmap
    '''
    if len(s) != len(t):
        return False

    records = {}

    for i in s:
        if i in records:
            records[i] += 1
        else:
            records[i] = 1

    for j in t:
        if j not in records:
            return False
        else:
            records[j] -= 1
            if records[j] < 0:
                return False

    for value in records.values():
        if value != 0:
            return False

    return True
    '''

    # 方法1.2：用2个hashmap，比较两个hm是否相等
    '''
    if len(s) != len(t):
        return False

    s_records = {}
    t_records = {}

    for i in s:
        if i in s_records:
            s_records[i] += 1
        else:
            s_records[i] = 1

    for j in t:
        if j in t_records:
            t_records[j] += 1
        else:
            t_records[j] = 1

    return s_records == t_records
    '''

    # 方法2：在defaultdict(int)中，如果i不在defaultdict中，defaultdict[i]返回0
    '''
    from collections import defaultdict
    s_dic = defaultdict(int)
    t_dic = defaultdict(int)

    for i in s:
        s_dic[i] += 1

    for j in t:
        t_dic[j] += 1

    return s_dic == t_dic
    '''

    # 方法3：Counter()返回一个dict，里面是每个元素的个数
    from collections import Counter

    s_counter = Counter(s)
    t_counter = Counter(t)

    return s_counter == t_counter
