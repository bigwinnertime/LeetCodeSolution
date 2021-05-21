package org.bigwinner.leetcode.Simple.Tree;

import static org.bigwinner.leetcode.Simple.Tree.TreeNode.constructTree;

/**
 * @author: bigwinner
 * @date: 2020/10/10 9:32 上午
 * @version: 1.0.0
 * @description: 检验树是否相同
 */
public class IsSameTree_100 {
    /**
     * 深度优先算法
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树节点有且只有一个树为空，则肯定不相同
        if (p == null && q == null) return true;
            // 如果两个树都为null，则相同
        else if (p == null || q == null) return false;
            // 如果两个树的节点值不一致，则肯定不相同
        else if (p.val != q.val) return false;
            // 遍历数判断两个树的节点是否相同
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{2,1,2};
        Integer[] nums2 = new Integer[]{2,1,3};
        TreeNode a = constructTree(nums1);
        TreeNode b = constructTree(nums2);
        System.out.println(isSameTree(a, b));
    }
}
