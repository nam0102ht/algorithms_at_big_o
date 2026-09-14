package com.ntnn.amazon;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
      this.value = value;
    }
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      // Number of nodes belonging to the current level
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        currentLevel.add(current.value);
        if (current.left != null) {
          queue.offer(current.left);
        }
        if (current.right != null) {
          queue.offer(current.right);
        }
      }
      result.add(currentLevel);
    }
    return result;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(levelOrder(root));

  }
}
