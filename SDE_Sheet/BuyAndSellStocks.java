import java.util.*;
public class Solution {
    public static int bestTimeToBuyAndSellStock(int []arr) {
        // Write your code here.
        int n = arr.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfir = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            minPrice = Math.min(minPrice,arr[i]);
            maxProfir = Math.max(maxProfir,arr[i]-minPrice);
        }
        return maxProfir;
    }
}
