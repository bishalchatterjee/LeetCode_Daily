import java.util.ArrayList;
import java.util.List;

public class q66 {
    //52. N-Queens II
    //Matrix,Backtracking
    //05/06/2022

    //N-Queens II modification
    static int countPossibleNQueens(int n){
        List<List<String>> ans=placeNQueens(n);
        return ans.size();
    }

    //rest everything is same as N-Queens (I)

    static List<List<String>> placeNQueens(int n) {
        char[][] chess_board = new char[n][n];  // creating the chess board
        for (int i = 0; i < n; i++)            //filling the 2D chess_board array with '.' as the default value
            for (int j = 0; j < n; j++)
                chess_board[i][j] = '.';

        List<List<String>> res = new ArrayList<List<String>>(); //create a list<list<string>>
        int leftRow[] = new int[n]; // array to store  the values of left row
        int upperDiagonal[] = new int[2 * n - 1];    // upper diagonal of size 2*n-1
        int lowerDiagonal[] = new int[2 * n - 1];        //lower diagonal of size 2n-1
        solve(0, chess_board, res, leftRow, lowerDiagonal, upperDiagonal);   //helper function call
        return res;  //returning the final list<list<string>>
    }

    static void solve(int col, char[][] chess_board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == chess_board.length) {  // check if current column is the last column then all the queens must have been placed by now
            res.add(construct(chess_board));  //add the final formation to the arraylist
            return;    // return to the parent function call
        }
        for (int row = 0; row < chess_board.length; row++) {   // start the traversal from first row
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[chess_board.length - 1 + col - row] == 0) {  //check for all the possibilities 0 means queen not present 1 means a queen is already placed in adj rows and will attack the queen of curr row
                chess_board[row][col] = 'Q';  // if not found place the queen at current position
                //after placing a queen we mark with 1 (indicating the presence of queen for future checks)
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[chess_board.length - 1 + col - row] = 1;

                //recursive calling for next column
                //if any time the conditions are not valid then we restore the changed values to default ie.. 1's with 0's and  'Q' with '.'
                solve(col + 1, chess_board, res, leftRow, lowerDiagonal, upperDiagonal); //backtrack and remove the placed Q's and replace all the values to default
                chess_board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[chess_board.length - 1 + col - row] = 0;

            }
        }
    }

    static List < String > construct(char[][] board) { // construct the chess board
        List < String > res = new ArrayList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String args[]) {
        int N = 8;
        System.out.println(countPossibleNQueens(N));
        }
}

//T.C - O(N! * N)
//S.C - O(N)

/*
Approach 2
(Without actually forming the combinations we only count )

class Solution {
    int count = 0; //global variable
    public void total(int row ,int n , boolean[] cols,boolean[] nDiagnol,boolean[] rDiagnol){
        if(row==n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(!cols[col] && !nDiagnol[row+col] && !rDiagnol[row-col+n-1]){
                cols[col]=true;
                nDiagnol[row+col]=true;
                rDiagnol[row-col+n-1]=true;
                total(row+1,n,cols,nDiagnol,rDiagnol);
                cols[col]=false;
                nDiagnol[row+col]=false;
                rDiagnol[row-col+n-1]=false;
            }
        }
    }
    public int totalNQueens(int n) {
     boolean[] cols = new boolean[n];
     boolean[] nDiagnol = new boolean[2*n-1];
     boolean[] rDiagnol = new boolean[2*n-1];
        total(0,n,cols,nDiagnol,rDiagnol);
        return count;
    }
}
 */