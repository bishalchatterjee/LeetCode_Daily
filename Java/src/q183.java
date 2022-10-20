import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int x;
    int height;

    Pair(int x,int height){
        this.x=x;
        this.height=height;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.x != o.x)
            return this.x=o.x;
        else
            return this.height=o.height;
    }
}
public class q183 {
    //218. The Skyline Problem
    //Priority Queue, Matrix
    //Date - 30/09/2022
    static List<List<Integer>> getSkyline(int[][] buildings){
        List<Pair> list=new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            int startPoint=buildings[i][0];
            int endPoint=buildings[i][1];
            int height=buildings[i][2];

            list.add(new Pair(startPoint, -endPoint));
            list.add(new Pair(endPoint, height));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> res=new ArrayList<>();

        int currHeight=0;
        pq.offer(0);

        for (int i = 0; i < list.size() ; i++) {
            int x=list.get(i).x;
            int height=list.get(i).height;

            if(height < 0){
                pq.offer(-height);
            }else{
                pq.remove(height);
            }

            if(currHeight!=pq.peek()){
                List<Integer> temp=new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());

                res.add(temp);
                currHeight=pq.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        System.out.println(getSkyline(buildings));
    }
}


//T.C - O(n log n)