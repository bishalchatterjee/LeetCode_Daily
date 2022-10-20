import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class q140 {
    //
    //Priority Queue,HashMap,Arrays
    //Date-18/08/2022

    static int numberOfStepsToReduceArrayToHalf(int[] nums){
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // OR
           PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));

        for(int i:map.values()){
            pq.offer(i);
        }

        int sum=0;
        int count=0;

        while (sum < nums.length/2){
            sum+=pq.poll();
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={3,3,3,5,5,5,5,2,2,7};
        System.out.println(numberOfStepsToReduceArrayToHalf(nums));
    }
}


//T.C - O(n) // n--> length of nums array
//S.C - O(k) // k--> unique elements in array