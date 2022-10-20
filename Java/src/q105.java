import java.util.HashMap;
import java.util.Map;

class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4  right;
    TreeNode4(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class q105 {
    //105. Construct Binary Tree from Preorder and Inorder Traversal
    //Tree

    static TreeNode4 buildTreeFromInOrderAndPreOrder(int[] preorder,int[] inorder){
        Map<Integer,Integer> inMap=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);

        TreeNode4 root=helper(preorder,0, preorder.length-1,inorder,0, inorder.length-1,inMap);

        return root;
    }

    static TreeNode4 helper(int[] preorder,int preorderStart ,int preorderEnd ,int[] inorder,int inorderStart,int inorderEnd,Map<Integer,Integer> inMap){
        if((preorderStart > preorderEnd) || (inorderStart>inorderEnd))return null;

        TreeNode4 root=new TreeNode4(preorder[preorderStart]);
        int inorderRoot=inMap.get(root.val);
        int numsLeft=inorderRoot-inorderStart;

        root.left=helper(preorder,preorderStart+1,preorderStart+numsLeft,inorder,inorderStart,inorderRoot-1,inMap);

        root.right=helper(preorder,preorderStart+numsLeft+1,preorderEnd,inorder,inorderRoot+1,inorderEnd,inMap);
        return root;

    }

    static void printTree(TreeNode4 root){
        if(root!=null)
            System.out.print(root.val+" ");
            if(root.left!=null) printTree(root.left);
            if(root.right!=null) printTree(root.right);
    }

    public static void main(String[] args) {
        int preorder[]={10,20,40,50,30,60};
        int inorder[]={40,20,50,10,60,30};



        TreeNode4 root=buildTreeFromInOrderAndPreOrder(preorder,inorder);
        printTree(root);
    }

}
