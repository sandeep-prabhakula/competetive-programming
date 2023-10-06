class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        Arrays.sort(nums);
        int cnt = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int large = 1;
        for(int i=0;i<n;i++){
            if(nums[i]-1==lastSmaller){
                cnt++;
                lastSmaller = nums[i];
            }
            else if(nums[i]!=lastSmaller){
                cnt = 1;
                lastSmaller = nums[i];
            }
            large = Math.max(cnt,large);
        }
        return large;
    }
}