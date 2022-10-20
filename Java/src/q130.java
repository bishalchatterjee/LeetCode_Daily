public class q130 {
    //300. Longest Increasing Subsequence
    //DP
    //08/08/2022

    static int longestIncreasingSubsequence(int[] arr){
        int overall_max=0;
        int dp[]=new int[arr.length];

        for (int i = 0; i < dp.length ; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    if(dp[j]>max) max=dp[j];
                }
            }
            dp[i]=max+1;

            if(dp[i]>overall_max){
                overall_max=dp[i];
            }
        }
        return overall_max;
    }

    public static void main(String[] args) {
        int arr[]={10,20,30,1,2,6,5};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}

//T.C - O(n*n)
//S.C - O(n)