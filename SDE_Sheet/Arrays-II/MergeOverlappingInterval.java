class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,
                    (arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
                            if(intervals.length<=1)return intervals;

                    int[]cur = intervals[0];
                    list.add(cur);
                    for(int i[]:intervals){
                        int cf = cur[0];
                        int cl = cur[1];
                        int nf = i[0];
                        int nl = i[1];
                        if(cl>=nf){
                            cur[1] = Math.max(cl,nl);
                        }else{
                            cur = i;
                            list.add(cur);
                        }
                    }
                    return list.toArray(new int[list.size()][]);
    }
}