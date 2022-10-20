import java.util.PriorityQueue;
import java.util.Queue;

public class q141 {
    //871. Minimum Number of Refueling Stops
    //
    //

    static int minRefuelStopsTillDestination(int target, int startFuel, int[][] stations) {
//        Given --> station[position][fuel]
        int position= stations.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[1]-a[1]));

        int i=0;
        int refill=0;
        int distance=startFuel;

        while(distance<target){
            while(i<position && distance>=stations[i][0]){
                pq.offer(stations[i]);
                i++;
            }
            if(pq.isEmpty()) return -1;

            distance+=pq.remove()[1];
            refill++;
        }
        return refill;
    }

    public static void main(String[] args) {
       int target = 100, startFuel = 10;
       int[][] stations = {{10,60},{20,30},{30,30},{60,40}};

        System.out.println(minRefuelStopsTillDestination(target,startFuel,stations));
    }
}

//T.C - O(nlogn)
//S.C - O(position) //where position is station.length