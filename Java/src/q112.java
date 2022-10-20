class ListNode2{
    int val;
    ListNode2 next;
    ListNode2(int val){
        this.val=val;
    }
}
public class q112 {
    //92. Reverse Linked List II (reverse from left to right where left<=right)
    //LinkedList
    //Date-21/07/2022

    static ListNode2 reverseLinkedList(ListNode2 head,int left,int right){

        if(head==null || left==right) return head; // base cases

        ListNode2 dummy=new ListNode2(0); //dummy node to keep track of the head of linked list
        dummy.next=head;

        ListNode2 prev=dummy;
        for(int i=0;i<left-1;i++)
            prev=prev.next; //node referring to the node before reversing

        ListNode2 start = prev.next;  //reference to the beginning of a sub-list that will be reversed
        ListNode2 to_reverse=start.next;//reference to the node that will be reversed

        for (int i = 0; i <right-left ; i++) { //to reverse all sub-lists nodes from the actual sublist to be reversed
            start.next=to_reverse.next;
            to_reverse.next=prev.next;
            prev.next=to_reverse;
            to_reverse=start.next;
        }
        //number of traversals will be = right-left
        //first  traversal:  dummy->1->3->2->4->5 (prev=1, start=2, to_reverse=4)
        //second traversal : dummy->1->4->3->2->5 (prev=1, start=2, to_reverse=5(end reached))

        return dummy.next;
    }

    static void printList(ListNode2 head){
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null) System.out.print("->");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        ListNode2 head=new ListNode2(1);
        head.next=new ListNode2(2);
        head.next.next=new ListNode2(3);
        head.next.next.next=new ListNode2(4);
        head.next.next.next.next=new ListNode2(5);


        int left=2,right=4;
        ListNode2 res=reverseLinkedList(head,left,right);
        printList(res);


    }
}


//T.C - O(N)
//S.C - O(1)