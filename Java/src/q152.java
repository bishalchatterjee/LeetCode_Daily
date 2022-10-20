import java.util.Arrays;

public class q152 {
    //48. Rotate Image
    //
    //

    static int[][] rotate90AntiClock(int matrix[][]) {
        transposeImage(matrix);

        // reverse each row of the matrix
        for(int row = 0; row < matrix.length; row++) {
            int i = 0;
            int j = matrix[row].length - 1;
            while(i < j) {
                int tmp = matrix[row][i];
                matrix[row][i++] = matrix[row][j];
                matrix[row][j--] = tmp;
            }
        }
        return matrix;
    }


    // Turns rows into cols and vice versa
    static void transposeImage(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    static void printMatrix(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        printMatrix(rotate90AntiClock(matrix));

    }

}
