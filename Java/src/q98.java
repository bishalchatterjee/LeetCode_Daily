public class q98 {
    //97. Interleaving String
    //DP,Strings
    //07/07/2022

    static boolean isInterleaveTabulationDP(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) return false;
        if(helper(s1,s2,s3)) return true;
        return false;
    }
    static boolean helper(String s1, String s2, String s3){
        boolean dp[][]=new boolean[s1.length()+1][s2.length()+1];

        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp[0].length ; j++) {
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=s2.charAt(j-1)==s3.charAt(i+j-1)? dp[i][j-1] : false;
                else if(j==0)
                    dp[i][j]=s1.charAt(i-1)==s3.charAt(i+j-1)? dp[i-1][j] : false;
                else{
                    if(s1.charAt(i-1)==s3.charAt(i+j-1)) dp[i][j]=dp[i-1][j];

                    if(!dp[i][j] && s2.charAt(j-1)==s3.charAt(i+j-1)) dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length - 1];
    }
    /*
    Memoization approach (Correct but -> TLE)

    static boolean isInterleaveMemoizationDP(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) return false;

        int i=0,j=0;
        boolean dp[][]=new boolean[s1.length()+1][s2.length()+1];
        if(helper2(s1,s2,s3,i,j,dp)) return true;
        return false;
    }
    static boolean helper2(String s1, String s2, String s3 ,int i,int j,boolean dp[][]) {
        int len1=s1.length(), len2=s2.length(), len3=s3.length();

        if(i==len1 && j==len2) return true;

        if(dp[i][j] == true)
            return dp[i][j];
        if(i<len1 && s1.charAt(i)==s3.charAt(i+j)){
            boolean flag=helper2(s1,s2,s3,i+1,j,dp);
            dp[i][j]=flag;
            if(flag==true) return true;
        }
        if(j<len2 && s2.charAt(j)==s3.charAt(i+j)){
            boolean flag=helper2(s1,s2,s3,i,j+1,dp);
            dp[i][j]=flag;
            if(flag==true) return true;
        }
        dp[i][j]=false;
        return false;
    }
     */

    public static void main(String[] args) {
//        String s1="aabcc";
//        String s2="dbbca";
//        String s3="aadbbcbcac";

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";

        System.out.println(isInterleaveTabulationDP(s1,s2,s3));
    }
}

//T.C - O(n*n)
//S.C - O(n*n)
