import java.util.ArrayDeque;
import java.util.Deque;

public class q100 {
    static int maxResult(int[] nums, int k) {

        int n=nums.length;

        Deque<Integer> dq=new ArrayDeque<>();

        dq.offerLast(0);

        for(int i=1;i<n;i++){
            System.out.print("nums[i]="+nums[i]+"    ");
            System.out.print("dq.peekFirst()="+dq.peekFirst()+"    ");
            System.out.print("nums[dq.peekFirst()]="+nums[dq.peekFirst()]);
            System.out.println();
            nums[i]=nums[i] + nums[dq.peekFirst()];

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i-dq.peekFirst() >= k){
                dq.pollFirst();
            }

        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        int nums[]={1,-1,-2,4,-7,3};
        int k=2;

        System.out.println(maxResult(nums,k));
    }
}
