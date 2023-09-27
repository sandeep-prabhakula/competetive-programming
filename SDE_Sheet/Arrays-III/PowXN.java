public class Solution {
    public static double myPow(double x, int n) {
        if(n==0)return 1.0;
        if(n==1)return x;
        if(n<0)return 1/f(x,n*-1);    
        return f(x,n);
    }
    public static double f(double x,int n){
        if(n==0)return 1.0;
        if((n&1)!=0)return x*f(x*x,n/2);
        return x*f(x,n-1);
    }
    
}