import java.util.HashMap;

public class q6 {
    static int threeSumMultiply(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res=0;
        int mod=1000000007;

        for(int i=0;i<arr.length;i++){
            res=(res+map.getOrDefault(target-arr[i],0))% mod;



            for(int j=0;j<i;j++){
                int temp=arr[i]+arr[j];
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3,4,4,5,5};
        System.out.println(threeSumMultiply(arr,8));
    }
}


/*
Array Approach

class Solution {
     public int threeSumMulti(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }
}
 */