import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> mat, Integer n, Integer m) {
    	boolean[]row = new boolean[n];
    	boolean[]col = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat.get(i).get(j)==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] || col[j])mat.get(i).set(j,0);
            }
        }
        return mat;
    }
}