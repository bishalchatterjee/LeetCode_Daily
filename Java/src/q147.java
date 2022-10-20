public class q147 {
    //383. Ransom Notes
    //HashMap,Arrays,Strings
    //Date-25/08/2022

    static boolean isPossibleRansomNoteFromMagazineNotes(String ransomNotes, String magazineNotes){
        if(ransomNotes == null || magazineNotes==null) return false;

        int[] freqCount=new int[26];

        for (int i = 0; i < magazineNotes.length() ; i++) {
            freqCount[magazineNotes.charAt(i)-'a']++;
        }

        for (int i = 0; i < ransomNotes.length(); i++) {
            if(--freqCount[ransomNotes.charAt(i)-'a']<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNotes="a";
        String magazineNotes="b";

        System.out.println(isPossibleRansomNoteFromMagazineNotes(ransomNotes,magazineNotes));
    }
}


//T.C - O(n)  //ransomNotes.length()
//S.C - O(1)  //array of size 26 which is constant



/*
Space UnOptimised
T.C - O(n)
S.C - O(n) //for map entries



 */