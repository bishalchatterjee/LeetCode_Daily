import java.util.HashMap;

public class q138 {
    //387. First Unique Character in a String
    //HashMap,Strings
    //Date-16/08/2022


    static int firstUniqChar(String s){
        int len=s.length();
        if(len==0) return -1;

        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < len ; i++) {
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqChar(s));
    }
}


//T.C - O(len)
//S.C - O(len)