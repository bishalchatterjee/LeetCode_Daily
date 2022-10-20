import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class q9 {
    static int[] topKFrequent(int[] nums, int k) {

        ArrayList<Integer> al=new ArrayList<>();
        int repeat=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);




        for(int i=0;i<nums.length;i++){
                if(map.get(nums[i])>=k && repeat!=nums[i]) {
                     al.add(nums[i]);
                    repeat = nums[i];
                }
        }
        if(al.isEmpty()) al.add(-1);

        int[] res = al.stream().mapToInt(i -> i).toArray();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
}





/*
    static int[] topKFrequent(int[] nums, int k) {

        int res_count=0;
        int repeat=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);

        int res[]=new int[nums.length];
        System.out.println(Arrays.asList(map));

        for(int i=0;i<nums.length;i++){
                if(map.get(nums[i])>=k && repeat!=nums[i]) {
                    res[res_count] = nums[i];
                    repeat = nums[i];
                    res_count++;
                }
        }
        return res;
    }
 */