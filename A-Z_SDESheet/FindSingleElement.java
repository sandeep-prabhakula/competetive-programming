public class Solution {
    public static int getSingleElement(int []arr){
        // Write your code here.
        int res = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            res^=arr[i];
        }
        return res;
    }
}