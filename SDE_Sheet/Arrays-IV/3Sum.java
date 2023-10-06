class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>>set = new HashSet();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer>list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else k--;
            }
        }
        return new ArrayList(set);
    }
}