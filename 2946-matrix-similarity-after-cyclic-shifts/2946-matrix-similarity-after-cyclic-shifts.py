class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        n = len(mat[0])
        k %= n
        if not k:
            return True
        for row in mat:
            for j in range(n-k):
                if row[j]!=row[j+k]:
                    return False
            start = 0
            for j in range(n-k,n):
                if row[j]!=row[start]:
                    return False
                start+=1
        return True