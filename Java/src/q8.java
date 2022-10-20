import java.util.Collections;
import java.util.PriorityQueue;

public class q8 {
    //1046. Last Stone Weight
    //Priority-Queue(Max Heap) , Arrays
    //Date - 07/04/2022
    static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max_heap=new PriorityQueue<>(Collections.reverseOrder());  // [max heap] priority queue  //sort priority queue in descending order
        for(int weight:stones){   //adding elements from stone array to priority queue
            max_heap.add(weight);
        }
        while(max_heap.size()!=1 && !max_heap.isEmpty()){   //while the size is at least 2
            int y=max_heap.poll();  //get y
            int x=max_heap.poll();  // get x
            if(x!=y) max_heap.add(y-x);  //if it is possible to combine them add them to the priority queue
        }
        if(max_heap.size()==1) return max_heap.peek();   //else if there is only last element after combination of all stones return the ans
        return 0;
    }

    public static void main(String[] args) {
        int stones[]={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

}

//T.C - O( log n)
//S.C -O(length of stones array)