import java.util.Arrays;

public class q103 {
    //473. Matchsticks to Square
    //DP,Backtracking,DFS
    //12/07/2022

//    https://www.youtube.com/watch?v=mljJKb-B5gg

    static boolean makeSquare(int arr[]){
        if(arr.length==0 || arr.length<4) return false;

        int perimeterOfSquare=0;

        for(int i:arr)
            perimeterOfSquare+=i;
        if(perimeterOfSquare%4!=0) return false;

        int index=0;
        int sum[]=new int[4];
        int target=perimeterOfSquare/4; //max length of one side of the square


        Arrays.sort(arr);
        reverse(arr);

        return dfs(arr,sum,index,target);
    }
    static boolean dfs(int arr[],int sum[],int index,int target){
        if(index==arr.length){
            if(sum[0]==sum[1] && sum[1]==sum[2] && sum[2]==sum[3]) return true;  // or if(sum[0]==target && sums[1]==target && sum[2]==target && sums[3]==target) return true;
            return false;
        }


        for (int i = 0; i < 4; i++) {
            if(sum[i]+arr[index] > target) // if the sum is already greater than the target then continue to next iteration;
                continue;

            sum[i]+=arr[index];
            if(dfs(arr,sum,index+1,target))return true;
            sum[i]-=arr[index];  //backtracking
        }
        return false;
    }
    static void reverse(int arr[]){  //function to reverse array elements
        int i=0;
        int j=arr.length-1;

        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;
        }

    }

    public static void main(String[] args) {
//        int[] arr={1,1,2,2,2};
        int[] arr={3,3,3,3,4};

        System.out.println(makeSquare(arr));
    }

}


//T.C --> O(n^4)

