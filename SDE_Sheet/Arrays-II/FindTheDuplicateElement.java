import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int[]res = new int[n+1];
        for(int i=0;i<n;i++){
            if(res[arr.get(i)]<=0)res[arr.get(i)]++;
            else return arr.get(i);
        }
        return -1;
    }
}
