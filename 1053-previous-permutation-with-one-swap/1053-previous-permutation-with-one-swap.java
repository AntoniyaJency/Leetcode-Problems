class Solution {
    public int[] prevPermOpt1(int[] arr) {

        int n = arr.length;
        int i = n - 2;

        // Step 1: find first index from right where arr[i] > arr[i+1]
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // If no such index, return same array
        if (i < 0) return arr;

        // Step 2: find the largest element smaller than arr[i]
        int j = n - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }

        // Handle duplicates: move left to get rightmost smaller element
        while (j > 0 && arr[j] == arr[j - 1]) {
            j--;
        }

        // Step 3: swap
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}
