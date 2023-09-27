import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int m = mat.size();
        int n = mat.get(0).size();
        int l = 0;
        int r = m*n-1;
        while(l<=r){
            int mid = (l+r)/2;
            int val = mat.get(mid/n).get(mid%n);
            if(val == target)return true;
            else if(val<target)l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}
