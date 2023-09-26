class Solution {
    public void moveZeroes(int[] nums) {
        int b = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                //Swapping the non-zero elements to the begin of array
                int t = nums[b];
                nums[b] = nums[i];
                nums[i] = t;
                b++;
            }
        }
    }
}