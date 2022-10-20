import java.util.HashMap;

public class q34 {
    //1679.Max Number of K-Sum Pairs (count number of disjoint pairs with given sum)
    //HashMap , Greedy
    //Date- 04/05/2022

    static int findPairsWithSumK(int nums[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();

        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i]) && map.get(k-nums[i])>0){ //check if the k-nums[i] is already present in the hashmap and the frequency should be > 0
                count++;  //if true, increase the count
                map.put(k-nums[i],map.get(k-nums[i])-1);  //and put the number back with frequency  reduced by 1
            }else
                map.put(nums[i],map.getOrDefault(nums[i],0)+1); //otherwise put nums[i] and increase its frequency by 1 (in case of already present nums[i] we increase the previous frequency otherwise if not found we put it with frequency 0+1; where 0 is default value;
        }
        return count;//finally, return the count
    }

    public static void main(String[] args) {
        int nums[]={1,4,2,3};
        int k=5;
        System.out.println(findPairsWithSumK(nums,k));
    }
}
