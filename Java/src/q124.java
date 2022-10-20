import java.util.PriorityQueue;

public class q124 {
    //378. Kth Smallest Element in a Sorted Matrix
    //Binary Search, PriorityQueue(Max Heap), UpperBound, Matrix
    //Date-02/08/2022

    static int m, n;

    static int kthSmallestinSortedMatrix(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length; // For general, the matrix need not be a square
        int left = matrix[0][0], right = matrix[m - 1][n - 1], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else left = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }

    static int countLessOrEqual(int[][] matrix, int x) { //same as upper_bounds
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] matrix={{1,5,9},{10,11,13},{12,13,15}};
        int k=8;

        System.out.println(kthSmallestinSortedMatrix(matrix,k));

    }
}
//T.C-O((M+N)*log k)
//S.C-O(1)

/*
Priority Queue (Max heap)(Brute Force)
class Solution { // 14 ms, faster than 55.67%
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length; // For general, the matrix need not be a square
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}

//T.C-O(M*N*log k)
 */