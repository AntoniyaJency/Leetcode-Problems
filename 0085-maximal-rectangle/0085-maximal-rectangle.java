class Solution {

    public int maximalRectangle(char[][] matrix) {

        // if matrix is empty
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];
        int maxArea = 0;

        // go row by row
        for (int i = 0; i < rows; i++) {

            // build height array
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    height[j] = height[j] + 1;
                else
                    height[j] = 0;
            }

            // find max rectangle for this row
            int area = maxHistogram(height);
            if (area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }

    // simple histogram calculation (no stack)
    public int maxHistogram(int[] h) {

        int max = 0;

        for (int i = 0; i < h.length; i++) {

            int minHeight = h[i];

            for (int j = i; j < h.length; j++) {

                if (h[j] < minHeight)
                    minHeight = h[j];

                int width = j - i + 1;
                int area = minHeight * width;

                if (area > max)
                    max = area;
            }
        }

        return max;
    }
}
