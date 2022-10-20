import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3(int val) {
        this.val = val;
    }
}

public class q104 {
    //102. Binary Tree Level Order Traversal
    //BFS,Tree
    //13/07/2022

    static List<List<Integer>> printLevelOrderTraversal(TreeNode3 root){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int curr_depth=0;
        bfs(root,res,curr_depth);
        return res;
    }

    static void bfs(TreeNode3 root, List<List<Integer>> res, int curr_depth){  //helper bfs
        if(root==null) return;
        if(curr_depth==res.size()){
            res.add(new LinkedList<Integer>());
//            System.out.println(curr_depth);
        }
        res.get(curr_depth).add(root.val);
//        System.out.println(res);
        bfs(root.left,res,curr_depth+1);
        bfs(root.right,res,curr_depth+1);
    }

    public static void main(String[] args) {
        TreeNode3 root=new TreeNode3(3);
        root.left=new TreeNode3(9);
        root.right=new TreeNode3(20);
        root.right.left=new TreeNode3(15);
        root.right.right=new TreeNode3(7);

        System.out.println(printLevelOrderTraversal(root));
    }
}

//T.C --> O(N)  //N ->number of nodes
//S.C --> O(1)
