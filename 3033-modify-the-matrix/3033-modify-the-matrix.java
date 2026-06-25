class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] answer=new int[m][n];
        

        /*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                answer[i][j]=matrix[i][j];      
                
        }*/

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                   int max = Integer.MIN_VALUE;
                   for(int k = 0; k < matrix.length; k++){
                        if(matrix[k][j] > max) max = matrix[k][j];
                    }
                    matrix[i][j]=max;
        
                }
            }
        }

        return matrix;
        
    }
}