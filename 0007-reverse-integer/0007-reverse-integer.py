class Solution(object):
    def reverse(self, x):
        sign = -1 if x < 0 else 1
        s = str(abs(x))        # remove negative sign
        rev = s[::-1]          # reverse string
        rev_int = int(rev) * sign

        # check 32-bit overflow
        if rev_int < -2**31 or rev_int > 2**31 - 1:
            return 0

        return rev_int
