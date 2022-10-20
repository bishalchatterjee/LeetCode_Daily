import java.util.*;

class NaryTreeNode{
    int val;
    List<NaryTreeNode> children;

    NaryTreeNode(int val){
        this.val = val;
        children = new ArrayList<NaryTreeNode>();
    }
}
public class q158 {
    //429. N-ary Tree Level Order Traversal
    //Trees,Queue
    //Date-5/9/2022

    static List<List<Integer>> levelOrderOfNaryTree(NaryTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Queue<NaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.size() > 0) {
            List<Integer> currLevel = new ArrayList<>();
            int len = q.size();

            for (int i = 0; i < len; i++) {
                NaryTreeNode node = q.poll();
                currLevel.add(node.val);

                for (NaryTreeNode childNode : node.children) {
                    q.offer(childNode);
                }
            }
            res.add(currLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        NaryTreeNode root = new NaryTreeNode(1);
        (root.children).add(new NaryTreeNode(3));
        (root.children).add(new NaryTreeNode(2));
        (root.children).add(new NaryTreeNode(4));
        (root.children.get(0).children).add(new NaryTreeNode(5));
        (root.children.get(0).children).add(new NaryTreeNode(6));

        List<List<Integer>> ans=levelOrderOfNaryTree(root);
        System.out.println(ans);
    }
}


//T.C - O(N) // N--> Number of nodes
//S.C - O(N)
