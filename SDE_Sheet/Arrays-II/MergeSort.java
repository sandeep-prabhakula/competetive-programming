public class MergeSort{
    public static void main(String[]args){
	// call for merge sort
    }
    public static void mergeSort(long[]arr,int l,int h){
        if(l==h)return;
        int mid = (h+l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, h);
        merge(arr,l,mid,h);
    }
    
    public static void merge(int[]arr,int l,int mid,int h){
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