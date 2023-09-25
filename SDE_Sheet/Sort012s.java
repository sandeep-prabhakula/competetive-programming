import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] nums)
    {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i:nums){
            switch(i){
                case 0:c0++;
                    break;
                case 1:c1++;
                    break;
                case 2:c2++;
                    break;
            }
        }
        int i = 0;
        while(c0!=0){
            nums[i] = 0;
            i++;
            c0--;
        }
        while(c1!=0){
            nums[i] = 1;
            i++;
            c1--;
        }
        while(c2!=0){
            nums[i]=2;
            i++;
            c2--;
        }
    }
}