import java.util.*;
public class Solution {
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int ind = -1;
        int n = A.size();
        // find the breakpoint for the next permutatiion.
        for(int i=n-2;i>=0;i--){
            if(A.get(i)<A.get(i+1)){
                ind = i;
                break;
            }
        }

        // if breakpoint not found return the reversed array. 
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }


        // else swap the breakpoint with the next greater element of the array.
        for(int i=n-1;i>=ind;i--){
            if(A.get(i)>A.get(ind)){
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // then reverse the subarray to the right of breakpoint.
        List<Integer>subList = A.subList(ind+1, n);
        Collections.reverse(subList);
        return A;
    }
}