class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
public class q67 {
    //160. Intersection of Two Linked Lists
    //LinkedList,Two-Pointers,HashSet
    //06/06/2022

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null) return null;

        //find the length of both LL

        int len_A=findLengthOfLinkedList(headA); //pass the head of LL --> A
        int len_B=findLengthOfLinkedList(headB); //pass the head of LL --> B

        //Create new ListNode
        ListNode current_A=headA;
        ListNode current_B=headB;

        //check if Length of LL A is > than LL B

        if(len_A>len_B){
            for(int i=0;i<len_A-len_B;i++)  // if Length of LL A is greater
                current_A=current_A.next;
        }else{
            for(int i=0;i<len_B-len_A;i++)  // if Length of LL B is greater
                current_B=current_B.next;
        }

        //check for intersection

        while(current_A != null){
            if((current_A.val)==(current_B.val)) return current_A;  // we found the intersecting point

            current_A=current_A.next;
            current_B=current_B.next;

        }
        return null;
    }

    //function to calculate the length of a linked list
    static int findLengthOfLinkedList(ListNode head){
        if(head==null) return 0;

        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode headA=new ListNode(4);
        headA.next=new ListNode(9);
        headA.next.next=new ListNode(8);
        headA.next.next.next=new ListNode(4);
        headA.next.next.next.next=new ListNode(5);

        ListNode headB=new ListNode(5);
        headB.next=new ListNode(6);
        headB.next.next=new ListNode(1);
        headB.next.next.next=new ListNode(8);
        headB.next.next.next.next=new ListNode(4);
        headB.next.next.next.next.next=new ListNode(5);


        ListNode ans=getIntersectionNode(headA,headB);
        System.out.println("Intersection Found : "+ans.val);

    }
}


//T.C - O(len_A+len_B)
//S.C - O(1)


/*
With ExtraSpace
Using a hashset (Traverse A or B and add all its nodes to the set. Then traverse the other and check if it's in the set.)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode currA = headA;
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null) {
            if (set.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }
        return null;
    }
}


 */