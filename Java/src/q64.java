public class q64 {
    //304. Range Sum Query 2D - Immutable
    //DP,prefix-sum,matrix
    //03/06/2022


    static int[][] dp;//Global dp array with sums

    static void NumMatrix(int[][] matrix) {
        int n = matrix.length;  //row
        int m = matrix[0].length; //column

        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = matrix[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
            }
        }
    }
        static int sumRegion(int row1,int col1,int row2,int col2){
//            System.out.println(dp[row2+1][col2+1]+"-"+dp[row2+1][col1]+"-"+dp[row1][col2+1]+"+"+dp[row1][col1]);
        return dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
        }

    public static void main(String[] args) {
        int[][] matrix={{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        NumMatrix(matrix);
        System.out.println(sumRegion(1,2,2,4));
        System.out.println(sumRegion(2,1,4,3));
    }
}
//T.C - O(M*N)
//S.C - O(1)

//Method 2
/*
Efficient T.C - O(1)
long[][] A;
  public NumMatrix(int[][] p) {
    int m= p.length, n= p[0].length;
    A= new long[m][n];

    //copy array to our array to find prefix
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++) A[i][j]= p[i][j];
    }

    //procedure for prefix in 2d array
    for(int i=1;i<m;i++){
        for(int j=0;j<n;j++) A[i][j]+= A[i-1][j];
    }

    for(int i=0;i<m;i++){
        for(int j=1;j<n;j++) A[i][j]+= A[i][j-1];
    }
  }

  //O(1) Time
  public int sumRegion(int r1, int c1, int r2, int c2) {
      long top=  (r1-1)>=0?   A[r1-1][c2]  :  0;
      long left= (c1-1)>=0?   A[r2][c1-1]  :  0;
      long diag= (r1-1)>=0 && (c1-1)>=0?  A[r1-1][c1-1]  :  0;
      return (int)( A[r2][c2]- top - left + diag );
  }
}

 */


/*
DP similar approach better readability

    static int[][] sums;//sums dp array

    static void NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        sums = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + matrix[i - 1][j - 1] - sums[i - 1][j - 1];
            }
        }
    }
        static int sumRegion(int row1,int col1,int row2,int col2){
            int Red_Rectangle=sums[row2+1][col2+1];
            int Purple_Rectangle=sums[row1][col2+1]+sums[row2+1][col1];
            int Blue_Rectangle=sums[row1][col1];
            return Red_Rectangle-Purple_Rectangle+Blue_Rectangle;
        }

 */