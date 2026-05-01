mn = lambda x, y: x if x < y else y

class Solution:
    def minMoves(self, balance: List[int]) -> int:

        if sum(balance) <  0: return -1                 # <--1
        if min(balance) >= 0: return  0

        n, ans, arr = len(balance), 0, []
        idx_neg, neg = min(enumerate(balance),          # <--2
                                key = lambda x: x[1])

        for i, bal in enumerate(balance):               # <--3
            if bal > 0:
                dist = mn(d:= abs(i - idx_neg), n - d) 
                arr.append([dist, bal])
        arr.sort()

        for dist, bal in arr:                           # <--4
            if neg + bal < 0:
                ans+= bal * dist
                neg+= bal
 
            else: return ans - neg * dist