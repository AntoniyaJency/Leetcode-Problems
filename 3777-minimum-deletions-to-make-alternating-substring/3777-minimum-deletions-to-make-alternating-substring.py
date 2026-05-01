class FenwickTree:
    def __init__(self, size):
        self.tree = [0] * (size + 1)

    def add(self, i, delta):
        while i < len(self.tree):
            self.tree[i] += delta
            i += i & (-i)

    def query(self, i):
        s = 0
        while i > 0:
            s += self.tree[i]
            i -= i & (-i)
        return s

class Solution:
    def minDeletions(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        A = [ord(c) - ord('A') for c in s]
        bit = FenwickTree(n)
        for i in range(n - 1):
            if A[i] == A[i+1]:
                bit.add(i + 1, 1)

        res = []
        for q in queries:
            if q[0] == 1:
                i = q[1]
                A[i] ^= 1
                if i > 0:
                    bit.add(i, 1 if A[i] == A[i - 1] else -1)
                if i < n - 1:
                    bit.add(i + 1, 1 if A[i] == A[i + 1] else -1)
            else:
                res.append(bit.query(q[2]) - bit.query(q[1]))
        return res