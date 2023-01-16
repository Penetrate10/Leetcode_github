import collections
from typing import List


def commonChars(self, words: List[str]) -> List[str]:
    """
    题目：查找相同字符
    方法：使用collections.Counter()得到频率，再求交集。
         求交集无需n个dic，只需要2个dic：1个是总的交集，1个是每个单词的Counter(words[i])
    Example:
        Input: words = ["bella","label","roller"]
        Output: ["e","l","l"]
    """
    intersection = collections.Counter(words[0])
    for i in range(1, len(words)):
        frequency = collections.Counter(words[i])

        # 取交集写法1：用 &
        intersection = intersection & frequency

        # 取交集写法2：用 for + min()
        '''
        for j in intersection.keys():
            intersection[j] = min(intersection[j], frequency[j])
        '''

    res = []
    for i in intersection.keys():
        for j in range(intersection[i]):
            res.append(i)
    return res
