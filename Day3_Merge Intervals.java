class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });
        
        List<int []> list = new ArrayList();
        int [] last=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=last[1]){
                last[1]=Math.max(intervals[i][1],last[1]);
            }else{
                list.add(last);
                last=intervals[i];
            }
        }
        list.add(last);

        
        int [][] result = new int [list.size()][2];
        int itr=0;
        for(int [] arr: list)
            result[itr++]=arr;
        
        return result;
    }
}