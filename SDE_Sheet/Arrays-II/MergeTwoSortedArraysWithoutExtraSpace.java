import java.util.*;
public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int n = a.length;
        int m = b.length;
        int l = n-1;
        int r = 0;
        while(l>=0 && r<m){
            if(a[l]>=b[r]){
                long temp = a[l];
                a[l] = b[r];
                b[r] = temp;
            }
            l--;
            r++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}