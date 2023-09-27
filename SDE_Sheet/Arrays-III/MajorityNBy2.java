import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int majorityElement(int []v) {
        Map<Integer,Integer>map = new HashMap<>();
        int n = v.length;
        for(int i:v)map.put(i,map.getOrDefault(i,0)+1);
        int and = -1;
        for(int i:map.keySet())if(map.get(i)>n/2)and = i;
        return and;
        
    }
}