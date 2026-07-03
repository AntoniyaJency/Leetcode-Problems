class Solution {
    public int[][] merge(int[][] intervals) {
        /*List<List<Integer>> list=new ArratList<>();
        int m=intervals.length;
        int n=intervals[0].length;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(intervals[i][j+1]>intervals[i+1][j]) list.add
            }
        }*/


        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] =
                Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
    
