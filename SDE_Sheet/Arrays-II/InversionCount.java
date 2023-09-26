import java.util.* ;
import java.io.*; 
public class Solution {
    static int count = 0;
    public static long getInversions(long arr[], int n) {
        mergeSort(arr, 0, n-1);
        return count;
    }
    
    public static void mergeSort(long[]arr,int l,int h){
        if(l==h)return;
        int mid = (h+l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, h);
        merge(arr,l,mid,h);
    }
    
    private static void merge(long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of 1st half of arr
        int right = mid + 1;   // starting index of 2nd half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count+=mid-left+1;
                right++;
            }
        }

        // if elements on the 1st half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the 2nd half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

}