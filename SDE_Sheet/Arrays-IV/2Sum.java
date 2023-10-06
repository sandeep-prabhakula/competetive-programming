public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(book[i]+book[j]==target)return "YES";
            
            }
        }
        return "NO";
    }
}