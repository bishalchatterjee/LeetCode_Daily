public class q2 {
    //680 . Valid Palindrome ||
    //String , Greedy , Two-Pointers
    //Date- 02/04/2022

    static boolean checkPalindromeFormationRemovingSingleCharacter(String s){
        int i=0; //start pointer
        int j=s.length()-1; //end pointer

        while(i<=j){  // stop when the two pointers overlap or cross each-other
            if(s.charAt(i)==s.charAt(j)){  //if the character at i matches
                i++;  //increment the first pointer
                j--;  //decrement the second pointer
            }
            //else if the character pointed by i doesn't match with character pointed by j that mean we found the characters that prevent the string from being palindrome
            else return isPalindromeString(s,i+1,j) || isPalindromeString(s,i,j+1);  // check if either of the possible new string is palindrome or not (here the unnecessary character is removed that was preventing the string from being palindrome)
        }
        return true;   //else if the string is already palindrome then simply return true
    }
    static boolean isPalindromeString(String s,int i,int j){  //to check the new string(after excluding a character)is palindrome or not
        while(i<=j) {   //get the i and j from the condition at line number 16
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;  //any of the character miss-match then the string can't be palindrome
        }
        return true;   //return true if it's a palindrome
    }

    public static void main(String[] args) {
        String s="abca";
        System.out.println(checkPalindromeFormationRemovingSingleCharacter(s));
    }
}

//T.C-O(n)   //where n=length of the string
//S.C-O(1)