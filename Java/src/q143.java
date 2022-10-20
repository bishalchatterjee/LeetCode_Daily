import java.util.ArrayList;
import java.util.List;

public class q143 {
    //
    //
    //
    static int[] movesToStamp(String stamp, String target) {

        char[] stamp_charArr = stamp.toCharArray();
        char[] target_charArr = target.toCharArray();

        int count = 0;
        boolean[] visited = new boolean[target_charArr.length];
        List<Integer> res = new ArrayList<>();

        while (count != target_charArr.length) {
            boolean changesDone = false;
            for (int i = 0; i <= target_charArr.length - stamp_charArr.length; i++) {
                if (!visited[i] && canReplace(target_charArr, stamp_charArr, i)) {
                    count = replaceCharWithQuestionMark(target_charArr, i, stamp_charArr.length, count);
                    visited[i] = true;
                    changesDone = true;
                    res.add(i);

                    if (count == target_charArr.length)
                        break;
                }
            }
            if (!changesDone)
                return new int[0];
        }

        int[] ans = new int[res.size()];
        int k=0;
        for (int i =res.size()-1; i >=0 ; i--) {
            ans[k++]=res.get(i);
        }
        
        return ans;
    }
    
    static boolean canReplace(char[] target_charArr,char[] stamp_charArr,int pos ){
        for (int i = 0; i < stamp_charArr.length ; i++) {
            if(target_charArr[i+pos] != '?' && target_charArr[i+pos] != stamp_charArr[i])
                return false;
        }
        return true;
    }

    static int replaceCharWithQuestionMark(char[] target_charArr,int pos,int len,int count){
        for (int i = 0; i < len ; i++) {
            if(target_charArr[i+pos]!='?'){
                target_charArr[i+pos]='?';
                count++;
            }
        }
        return count;
    }
}


//T.C - O(N*(N-M)) //where N-> length of target character array, M-> length of target character array - length of stamp character array
//S.C - O(N*(N-M))