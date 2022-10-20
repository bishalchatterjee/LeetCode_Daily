import java.util.Arrays;

public class q63 {
    //Transpose Matrix
    //Matrix
    //Date- 02/06/2022

    static int[][] transpose(int[][] matrix) {

        int m = matrix.length ; // rows
        int n = matrix[0].length ; // columns

        int[][] resultant = new int[n][m] ;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                resultant[j][i] = matrix[i][j] ;
            }
        }

        return resultant ;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}
//T.C- O(M*N)
//S.C- O(1)