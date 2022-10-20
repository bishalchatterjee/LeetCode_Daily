class TreeNode15{
    int val;
    TreeNode15 left;
    TreeNode15 right;

    TreeNode15(int val){
        this.val = val;
        left=right=null;
    }
}

public class q159 {
    //814. Binary Tree Pruning
    //Binary Tree
    //Date-06/09/2022

    static TreeNode15 pruningBinaryTree(TreeNode15 root){
        if(root==null)
            return null;

        root.left=pruningBinaryTree(root.left);
        root.right=pruningBinaryTree(root.right);
        if(root.left==null && root.right==null && root.val==0)
            return null;

        return root;
    }

    static void InorderTraversal(TreeNode15 root){ //printing the tree
        if (root == null)
            return;

        InorderTraversal(root.left);
        System.out.print(root.val + " ");
        InorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode15 root=new TreeNode15(1);
        root.right=new TreeNode15(0);
        root.right.left=new TreeNode15(0);
        root.right.right=new TreeNode15(1);


        InorderTraversal(pruningBinaryTree(root));
    }

}

//T.C - O(n)
//S.C - O(h) //height of tree //for inorder traversal