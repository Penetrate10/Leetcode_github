import collections


def canConstruct(self, ransomNote: str, magazine: str) -> bool:
    """
    题目：判断一个字符串的char能不能组成另一个字符串
    方法1：Hash Table：map
          collections.Counter  ->  -=1
          注意这里不要将两个字符串都Counter，白浪费空间。
          Counter一个，另一个在map的基础上-1即可，减到负数就输出False。
    方法2：Hash Table：set  +  String
          用set获得目标字符串的char都有什么，
          然后遍历看给定字符串中的某个char的个数 是否大于等于 目标字符串中的某个char的个数。
          string.count()很快
    方法3：String：“if i in string”

    Example 1:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false
    Example 2:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true
    """

    # 不要忘记排除特殊情况！
    if len(ransomNote) > len(magazine):
        return False

    # 方法1：Hash Table：map
    counter_magazine = collections.Counter(magazine)
    for char in ransomNote:
        if counter_magazine[char] == 0:
            return False
        else:
            counter_magazine[char] -= 1

    return True

    # 方法2：Hash Table：set  +  String
    '''
    for i in set(ransomNote):
        if magazine.count(i) < ransomNote.count(i):
            return False
    return True
    '''

    # 方法3：String：“if i in string”
    '''
    for i in ransomNote:
        if i not in magazine:
            return False
        magazine = magazine.replace(i, '', 1)  # replace(old, new, 替换几次)
    return True
    '''
