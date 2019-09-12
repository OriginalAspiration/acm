package edu.hubu.acm.InterviewAndPractice;

import java.util.Scanner;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Main
 * @Description TODO
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inLine = scanner.nextLine();
        System.out.println(inLine);
//        char[] in = inLine.toCharArray();
//        String lastline = scanner.nextLine();
//        char[] last = lastline.toCharArray();
//        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
//        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(in, last);
//        BinaryTreeVisit.preVisit(root);

    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}

class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(char[] in, char[] last) {
        TreeNode root = postAndInConstructBinaryTree(in, 0, in.length - 1, last, 0, last.length - 1);
        return root;
    }

    public TreeNode postAndInConstructBinaryTree(char[] in, int inStart, int inEnd, char[] last, int lastStart, int lastEnd) {
        if (inStart > inEnd || lastStart > lastEnd)
            return null;
        TreeNode treeNode = new TreeNode(last[lastEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == last[lastEnd]) {
                treeNode.left = postAndInConstructBinaryTree(in, inStart, i - 1, last, lastStart, lastStart + i - inStart - 1);
                treeNode.right = postAndInConstructBinaryTree(in, i + 1, inEnd, last, lastStart + i - inStart, lastEnd - 1);
            }
        }
        return treeNode;
    }
}

class BinaryTreeVisit {
    public static void preVisit(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val);
            preVisit(root.left);
            preVisit(root.right);
        }
    }
}


