import java.util.ArrayList;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int val) {
        this.val = val;
    }
}
public class q102 {
    //199. Binary Tree Right Side View
    //DFS,Tree
    //11/07/2022

    static List<Integer> printRightViewOfBinaryTree(TreeNode2 root){
        int curr_depth=0;
        List<Integer> res=new ArrayList<Integer>();
        dfs(root,res,0);
        return res;
    }

    static void dfs(TreeNode2 root, List<Integer> res,int curr_depth){
        if(root==null) return;
        if(curr_depth==res.size()){
            res.add(root.val);
        }
        //for right view
        dfs(root.right,res,curr_depth+1);
        dfs(root.left,res,curr_depth+1);

        //for left view
//        dfs(root.left,res,curr_depth+1);
//        dfs(root.right,res,curr_depth+1);

    }

    public static void main(String[] args) {
        TreeNode2 root=new TreeNode2(1);
        root.left=new TreeNode2(2);
        root.left.right=new TreeNode2(5);
        root.right=new TreeNode2(3);
        root.right.right=new TreeNode2(4);

        System.out.println(printRightViewOfBinaryTree(root));
    }
}

//T.C - O(N) //N--> number of nodes
//S.C - O(1)
