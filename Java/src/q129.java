import java.util.HashMap;
import java.util.Map;

public class q129 {
    //1220. Count Vowels Permutation
    //Strings,DP,HashMap
    //Date-07/08/2022

    static Map<String,Long> map=new HashMap<>(); //used to apply memoization
    static int mod=1000000007; //or static int mod=(int)(Math.pow(10,9)+7);


    static int countVowelPermutation(int n){
        long total=0;
        char[] charset=new char[]{'a','e','i','o','u'};
        for(char c:charset){
            total=(total+helper(n-1,c)) % mod;
        }
        return (int)total;
    }

    static long helper(int remaining_char,char previous_char){
        if(remaining_char==0) return 1;

       String key=""+remaining_char+previous_char;

       if(map.containsKey(key)) return map.get(key);

       long total=0;
       switch(previous_char){
           case 'a':
               total=(helper(remaining_char-1,'e'))%mod;
               break;
           case 'e':
               total=(helper(remaining_char-1,'a')+helper(remaining_char-1,'i'))%mod;
               break;
           case 'i':
               total=(helper(remaining_char-1,'a')+helper(remaining_char-1,'e')+helper(remaining_char-1,'o')+helper(remaining_char-1,'u'))%mod;
               break;
           case 'o':
               total=(helper(remaining_char-1,'i')+helper(remaining_char-1,'u'))%mod;
               break;
           case 'u':
               total=(helper(remaining_char-1,'a'))%mod;
               break;
       }
       map.put(key,total);
       return total;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(countVowelPermutation(n));
    }
}
