public class q97 {
    //509. Fibonacci Number
    //DP
    //06/07/2022


    static int fibonacciNumber(int n){

        if(n==0||n==1) return n;

        int dp[]=new int[n+1];
        dp[0]=0;//not necessary java it's already default value is 0
        dp[1]=1;
        for (int i = 2; i <n+1; i++) {
            dp[i]=dp[i-1]+dp[i-2];  //In Fibonacci Sequence --> F(n) = F(n-1) + F(n-2)
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(fibonacciNumber(n));
    }
}


//T.C - O(n)
//S.C - O(n)