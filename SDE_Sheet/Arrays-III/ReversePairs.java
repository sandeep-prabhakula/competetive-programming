class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return count;
    }
    public void mergeSort(int[]arr,int low,int high){
        if(low==high)return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
    }
    public void countPairs(int[]arr,int l,int mid,int h){
        int right = mid+1;
        for(int i=l;i<=mid;i++){
            while(right<=h && arr[i]>2*arr[right]){
                right++;
            }
            count = count+(right-(mid+1));
        }
    }
    public void merge(int[]arr,int l,int mid,int h){
        int left = l;
        int right = mid+1;
        
        List<Integer>list = new ArrayList();
        while(left<=mid && right<=h){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }
        //add the remaining elements from part 1 to the list
        while(left<=mid)list.add(arr[left++]);
            //add the remaining elements from part 2 to the list
        while(right<=h)list.add(arr[right++]);
        
        // sort the arr[] from the index l -> index h
        // l-l = 0, l+1-l = 1, l+2-l = 2, .... l+h-l;
        int k = 0;
        for(int i=l;i<=h;i++){
            arr[i] = list.get(k++);
        }
    }
}