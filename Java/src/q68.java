import java.util.Arrays;

public class q68 {
    //88. Merge Sorted Array
    //Two-Pointers
    //07/06/2022

        /*
        array nums1 contains the extra space to merger two arrays Hence we do not need extra space

        Eg- nums1={1,2,3,0,0,0} //0's are to be ignored and to be used as extra space //m= length of nums1 without the 0's =3
            nums2={2,4,5}                                                             //n= length of nums2
         */

    static int[] mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return nums1;  //return nums1 if nums2 is empty

        int end_pointer=m+n-1;  //pointer to keep track of the last index of the longest array
        m--;
        n--;

        while(n>=0) {
            if (m >= 0 && nums1[m] > nums2[n])
                nums1[end_pointer] = nums1[m--];   //since we have placed a number at mth index we decrement it by 1 (** post decrement is done after this step)
            else
                nums1[end_pointer] = nums2[n--];   //since we have placed a number at nth index we decrement it by 1

            end_pointer--;   //decrementing the last index after placing an element from the second array
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};int m=3;
        int[] nums2 ={2,4,5};int n=3;

        System.out.println(Arrays.toString(mergeTwoSortedArrays(nums1,m,nums2,n)));
    }
}


//T.C - O(m+n)
//S.C - O(1)