import java.util.*;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int rep = 0;
        HashSet<Integer>set = new HashSet();
        for(int i:arr){
            if(!set.add(i))rep = i;
        }        
        int sum = n*(n+1)/2;
        int actSum = 0;
        for (int i:arr)actSum+=i;
        int temp = Math.abs(actSum - rep);
        int miss = Math.abs(temp - sum);
        int[]res = new int[2];
        res[0] = miss;
        res[1] = rep;
        return res;
    }
}