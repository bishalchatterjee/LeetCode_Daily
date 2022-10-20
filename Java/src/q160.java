public class q160 {
    //Reverse a bit
    //BitMasking
    //Date-08/09/2022


    static void reverseABit(int n){
        boolean flag=false;
        int rev=0;
        int j=0;

        for (int i = 31; i >=0 ; i--) {
            int imask=(1 << i);

            if(flag){
                if((n & imask)!=0){
//                    System.out.print(1);
                    int jmask=(1<<j);
                    rev |=jmask;
                }
//                else{
//                  System.out.print(0);
//                }
                j++;
            }else{
                if((n & imask)!=0){
//                    System.out.print(1);
                    flag=true;

                    int jmask=(1<<j);
                    rev |=jmask;

                    j++;
                }
            }
        }
        System.out.println(rev);  //print rev
    }

    public static void main(String[] args) {
        int n=11;
        reverseABit(n);
    }
}

//T.C - O(1)
//S.C - O(1)


/*
function to print binary equivalent of a integer

    static void reverseABit(int n){
        boolean flag=false;

        for (int i = 31; i >=0 ; i--) {
            int mask=(1 << i); //turning the ith bit on for masking with n

            if(flag){
                if((n & mask)!=0){  // if & of n and mask is not 0 then print 1 else print 0
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }

            }else{
                if((n & mask)!=0){ //if first 1 is found then print the rest of 1,0's as it is
                    flag=true; //make flag true as we found first one
                    System.out.print(1);
                }
            }
        }
    }
 */
