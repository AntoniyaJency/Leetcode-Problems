class Solution:
    def buildLPS(self, pattern: str):
        n = len(pattern)
        lps = [0] * n

        length = 0
        i = 1

        while i < n:
            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1

        return lps

    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        text = s + s
        lps = self.buildLPS(goal)

        i = j = 0

        while i < len(text):
            if text[i] == goal[j]:
                i += 1
                j += 1

            if j == len(goal):
                return True
            elif i < len(text) and text[i] != goal[j]:
                if j != 0:
                    j = lps[j - 1]
                else:
                    i += 1

        return False