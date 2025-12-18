class Solution(object):
    def longestCommonPrefix(self, strs):
        if strs == []:
            return ""

        prefix = strs[0]

        for word in strs[1:]:
            while not word.startswith(prefix):
                prefix = prefix[:-1]

                if prefix == "":
                    return ""

        return prefix

        