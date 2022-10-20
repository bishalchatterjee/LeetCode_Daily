import java.util.ArrayList;
import java.util.List;

public class q114 {
     static int[] count;
     static List<Integer> countSmallerOnRight(int[] nums){
        List<Integer> res=new ArrayList<>();
        count=new int[nums.length];
        int[] originalIndex=new int[nums.length];

        for (int i = 0; i < nums.length ; i++) {
            originalIndex[i]=i;
        }

        mergeSort(nums,originalIndex,0,nums.length-1);

        for (int i = 0; i < nums.length ; i++) {
            res.add(count[i]);
        }

        return res;
    }

    static void mergeSort(int[] nums,int[] originalIndex,int left,int right){
         if(left<right){
             int mid=(left+right)/2;
             mergeSort(nums,originalIndex,left,mid);
             mergeSort(nums,originalIndex,mid+1,right);
             merge(nums,originalIndex,left,mid,right);
         }
    }
    static void merge(int[] nums,int[] originalIndex,int left,int mid,int right){
         int leftArraySize=mid-left+1;
         int rightArraySize=right-mid;

         int[] leftArray=new int[leftArraySize];
         int[] rightArray=new int[rightArraySize];


        for (int i = 0; i <leftArraySize ; i++) {
            leftArray[i]=originalIndex[left+i];
        }
        for (int i = 0; i <rightArraySize ; i++) {
            rightArray[i]=originalIndex[mid+i+1];
        }

        int i=0;
        int j=0;
        int k=left;
        int rightCount=0;

        while(i<leftArraySize && j<rightArraySize){
            if(nums[leftArray[i]]<=nums[rightArray[j]]){
                originalIndex[k]=leftArray[i];
                count[leftArray[i]]+=rightCount;
                i++;
            }else{
                originalIndex[k]=rightArray[j];
                rightCount++;
                j++;
            }
            k++;
        }
        while(i<leftArraySize){
            originalIndex[k]=leftArray[i];
            count[leftArray[i]]+=rightCount;
            i++;
            k++;
        }
        while (j<rightArraySize){
            originalIndex[k]=rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int nums[]={5,2,6,4,1};
        System.out.println(countSmallerOnRight(nums));

    }
}
