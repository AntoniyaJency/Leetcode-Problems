class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            if(grid[i][n-i-1]==0) return false;
            for(int j=0;j<n;j++){
                if(i==j && grid[i][j]==0) return false;
                

                if(i!=j && j!=n-i-1 && grid[i][j]!=0) return false;
                
            }
        }

        return true;
    }
}