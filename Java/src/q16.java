class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }


public class q16 {
    //538 . Convert BST to Greater Tree
    //Trees
    //Date- 16/04/2022

    static TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        helperConvertBST(root,0);
        return root;
    }
    static int helperConvertBST(TreeNode root, int leftGreater){
        if(root==null) return 0;
        if(root.right!=null)
                root.val+=helperConvertBST(root.right,leftGreater);
            else
                root.val+=leftGreater;
        if(root.left!=null)
            return helperConvertBST(root.left,root.val);

        return root.val;
    }
}

//T.C - O(N)
//S.C - O(H)
