//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int dp[][] = new int[201][201];
    int wildCard(String pattern, String str)
    {
        int n = pattern.length();
        int m = str.length();
        for(int i[]:dp)Arrays.fill(i,-1);
        int res = f(n-1,m-1,pattern,str);
        return res;
    }
    public int f(int i,int j,String s,String t){
        if(i<0 && j<0)return 1;
        if(i<0 && j>=0)return 0;
        if(j<0 && i>=0){
            for(int ii=0;ii<=i;ii++)if(s.charAt(ii)!='*')return 0;
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j) || s.charAt(i)=='?')return dp[i][j] = f(i-1,j-1,s,t);
        if(s.charAt(i)=='*')return dp[i][j] = f(i-1,j,s,t) | f(i,j-1,s,t);
        return dp[i][j] = 0;
    }
}
