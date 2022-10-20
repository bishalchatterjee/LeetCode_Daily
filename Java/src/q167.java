class TreeNode16{
    int val;
    TreeNode16 left,right;

    TreeNode16(int val){
        this.val=val;
        left=right=null;
    }
}

public class q167 {
    //1457. Pseudo-Palindromic Paths in a Binary Tree
    //BinaryTree
    //Date-14/09/2022


    static int res;
    static int[] map=new int[10];
    static int countPseudoPalindromicPaths(TreeNode16 root){
        helperDFS(root);
        return res;
    }
    static void helperDFS(TreeNode16 root){
        if(root==null) return;

        map[root.val]++;
        if(root.left==null && root.right==null){
            if(isPalindrom(map))
                res++;
        }
        helperDFS(root.left);
        helperDFS(root.right);

        //backtracking the made changes
        map[root.val]--;
    }
    static boolean isPalindrom(int[] map){
        int count=0;
        for (int i = 0; i <=9 ; i++) {
            if(map[i]%2!=0)
                count++;

            if(count>1)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode16 root=new TreeNode16(2);
        root.left = new TreeNode16(3);
        root.left.left = new TreeNode16(3);
        root.left.right = new TreeNode16(1);
        root.right = new TreeNode16(1);
        root.right.right = new TreeNode16(1);


        System.out.println(countPseudoPalindromicPaths(root));
    }
}

//T.C - O(H)
//S.C - O(1)