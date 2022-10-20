import java.util.Arrays;

public class q62 {
    //1480. Running Sum of 1d Array
    //Array
    //Date- 01/06/2022

    static int[] runningArraySum(int[] nums){
        int length = nums.length;
        for (int i = 1; i < length ; i++) {
            nums[i]+=nums[i-1];  //storing sum of previous elements in current index
        }
        return nums;    //returning the array
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        System.out.println(Arrays.toString(runningArraySum(nums)));
    }
}


//T.C- O(N)
//S.C- O(1)