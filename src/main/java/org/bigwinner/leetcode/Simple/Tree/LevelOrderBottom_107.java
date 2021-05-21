package org.bigwinner.leetcode.Simple.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2020/10/12 9:56 上午
 * @version: 1.0.0
 * @description: 二叉树的层次遍历
 */
public class LevelOrderBottom_107 {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层序遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 如果为空树，返回空
        if (root == null) return new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs (root, res, 1);
        // 翻转列表
        Collections.reverse(res);
        return res;
    }

    public static void dfs(TreeNode root, ArrayList<List<Integer>> res, int index) {
        // 如果当前节点为空，停止当前遍历
        if (root == null) return;
        // 若果列表大小小于index，说明当前层没有对应的集合，需要新建集合
        if (res.size() < index) res.add(new ArrayList<>());
        // 将当前节点的值放入集合
        res.get(index - 1).add(root.val);
        // 递归遍历左子树
        dfs (root.left, res, index + 1);
        // 递归遍历右子树
        dfs (root.right, res, index + 1);

    }

    public static void main(String[] args) {
        Integer[] num = new Integer[]{3,9,20,null,null,15,7};
        TreeNode t = TreeNode.constructTree(num);
        System.out.println(levelOrderBottom(t));
    }
}
