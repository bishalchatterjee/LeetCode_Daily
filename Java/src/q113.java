class ListNode3{
    int val;
    ListNode3 next;
    ListNode3(int val){
        this.val=val;
    }
}
public class q113 {
    static ListNode3 partitionLinkedListAroundK(ListNode3 head, int k){
    ListNode3 dummy1=new ListNode3(0); // to keep track of head of first LL with values less than K
    ListNode3 dummy2=new ListNode3(0); // to keep track of head of second LL with values greater than K (preserved order

    ListNode3 list1=dummy1;//first LL starts from dummy1
    ListNode3 list2=dummy2;//second LL starts from dummy2

    while(head!=null){
        if(head.val<k){ // check if its value is less than K
            list1.next=head; //add as the next new node to first LL
            list1=head; // point the list1 to current head;
        }else{
            list2.next=head; //add as the next new node to second LL
            list2=head; // point the list2 to current head;
        }
        head=head.next; //move head to next
    }
    list2.next=null; //As we link the first and second linked lists we need to make sure the node next to last node of the second list is "null"
    list1.next=dummy2.next; // linking the first list with second list; // as dummy was pointing to previous of head of second list

    return dummy1.next; // return head of first list
    }
    static void printList(ListNode3 head){ //simple print-list function
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null) System.out.print("->");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        ListNode3 head=new ListNode3(1);
        head.next=new ListNode3(4);
        head.next.next=new ListNode3(3);
        head.next.next.next=new ListNode3(2);
        head.next.next.next.next=new ListNode3(5);
        head.next.next.next.next.next=new ListNode3(2);


        int k=3;
        ListNode3 res=partitionLinkedListAroundK(head,k);
        printList(res);


    }

}

//T.C - O(N)
//S.C - O(1)