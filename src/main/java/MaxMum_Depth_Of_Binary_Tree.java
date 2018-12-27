import java.util.LinkedList;
import java.util.Queue;
/**
 *leetcode 104 二叉树的最大深度
 *Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Have you met this question in a real interview?
 * Yes
 * Example
 * Given a binary tree as follow:
 *
 *   1
 *  / \
 * 2   3
 *    / \
 *   4   5
 * The maximum depth is 3.
 *
 * */
public class MaxMum_Depth_Of_Binary_Tree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static int f1(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int lh = f1(treeNode.left);
        int rh = f1(treeNode.right);
        if (lh > rh) {
            return lh + 1;
        } else {
            return rh + 1;
        }
    }

    public static int f2(TreeNode treeNode) {
       if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =  0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;
    }

}
