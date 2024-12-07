package topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC267 从上往下打印二叉树
 * @author d3y1
 */
public class NC267 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        // bfs
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            list.add(node.val);
        }

        return list;
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}