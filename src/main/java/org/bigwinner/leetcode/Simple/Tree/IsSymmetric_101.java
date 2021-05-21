package org.bigwinner.leetcode.Simple.Tree;

/**
 * @author: bigwinner
 * @date: 2020/10/10 11:31 上午
 * @version: 1.0.0
 * @description: 检验是否为对称二叉树
 */
public class IsSymmetric_101 {
    public static boolean isSymmetric(TreeNode root) {
        // 空树是对称二叉树
        if (root == null) return true;
        // 镜像对比
        return compare(root.left, root.right);
    }
    public static boolean compare (TreeNode a, TreeNode b) {
        // 如果子节点都为null 则为对称二叉树
        if (a == null && b == null) return true;
        // 子节点有且只有一个为空 不是对称二叉树
        if (a == null || b == null) return false;
        // 如果两个节点的值不相等 则不为对称二叉树
        if (a.val != b.val) return false;
        // 递归判断是否镜像
        return compare(a.left, b.right) && compare(a.right, b.left);
    }

    public static void main(String[] args) {
//        Integer[] nums1 = new Integer[]{1,2,2,3,4,4,3};
//        Integer[] nums1 = new Integer[]{1,2,2,null,3,null,3};
//        Integer[] nums1 = new Integer[]{1,2,2,null,3,3};
//        Integer[] nums1 = new Integer[]{1,null,2};
        Integer[] nums1 = new Integer[]{1,2,3};
        TreeNode t = TreeNode.constructTree(nums1);
        System.out.println(isSymmetric(t));
    }
}
