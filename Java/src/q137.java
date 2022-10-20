import java.util.HashMap;

public class q137 {
    //13. Roman to Integer
    //HashMap,Strings
    //Date-15/08/2022
    static int romanToInteger(String s){
        int len=s.length();
        if(len == 0) return -1;

        HashMap<Character,Integer> map=new HashMap<>();
        //as per question constrains
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res=map.get(s.charAt(len-1)); // getting the corresponding key(from the map) of last character of the roman string;

        for (int i = len-2; i>=0 ; i--) { //traverse from backward direction(right to left)
            if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))) //fetching keys of character at i and i+1
                res+=map.get(s.charAt(i));
            else
                res-=map.get(s.charAt(i));

        }
        return res;
    }

    public static void main(String[] args) {
        String s="XVIII";
        System.out.println(romanToInteger(s));
    }
}


//T.C - O(len)
//S.C - O(1) // 8 character integer pairs to be exact