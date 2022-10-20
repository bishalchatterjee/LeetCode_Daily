import java.util.Arrays;

public class q127 {
    //377. Combination Sum IV
    //DP,Permutation/Combination
    //Date-05/08/2022

//    https://youtu.be/GWqe_xfqxCA

    //Memoization Approach
    static int dp[]; //global dp array

    static int combinationSum4(int[] nums, int target) {
        if(target==0) return 1;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0]=1;

        helper(nums, target);
        return dp[target];
    }

    static int helper(int[] nums, int target) {
        if(dp[target]!=-1){
            return dp[target];
        }
        int res=0;
        for(int i:nums) {
         if(i<=target)
            res += helper(nums, target - i);
        }
        dp[target]=res;//memoization(top-down)

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target=4;

        System.out.println(combinationSum4(nums,target));
    }
}

//T.C - O(N*target)
//S.C - O(target)

/*
Tabulation(Bottom Up) Approach

static int dp[]; //global dp array

    static int combinationSum4(int[] nums, int target) {
        if(target==0) return 1;
        dp = new int[target + 1];

        dp[0]=1;

        for(int i=1;i<=target;i++){
            for(int n:nums){
                if(i>=n){
                    dp[i]+=dp[i-n];
                }
            }
        }
        return dp[target];
    }

 */