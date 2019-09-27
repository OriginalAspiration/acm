package edu.hubu.acm.InterviewAndPractice;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName BinaryTree
 * @Description TODO
 * @createTime 2019年09月12日 17:02:00
 */
public class BinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ReConstructBinaryTree {
        public static TreeNode reConstructBinaryTree(int[] in, int[] last) {
            TreeNode root = postAndInConstructBinaryTree(in, 0, in.length - 1, last, 0, last.length - 1);
            return root;
        }

        public static TreeNode preAndInConstructBinaryTree(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
            if (pStart > pEnd || iStart > iEnd) {
                return null;
            }
            TreeNode root = new TreeNode(pre[pStart]);
            int k = findTargetIndex(in, pre[pStart], iStart, iEnd) - iStart;
            root.left = preAndInConstructBinaryTree(pre, pStart + 1, pStart + k, in, iStart, iStart + k - 1);
            root.right = preAndInConstructBinaryTree(pre, pStart + k + 1, pEnd, in, iStart + k + 1, iEnd);
            return root;
        }

        public static int findTargetIndex(int[] in, int target, int start, int end) {
            for (int i = start; i <= end; ++i) {
                if (in[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        public static TreeNode postAndInConstructBinaryTree(int[] in, int inStart, int inEnd, int[] last, int lastStart, int lastEnd) {
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

    public static class BinaryTreeVisit {
        public static void preVisit(TreeNode root) {
            if (root == null) {
                return;
            } else {
                System.out.print(root.val + " ");
                preVisit(root.left);
                preVisit(root.right);
            }
        }

        public static void inVisit(TreeNode root) {
            if (root == null) {
                return;
            } else {
                inVisit(root.left);
                System.out.print(root.val + " ");
                inVisit(root.right);
            }
        }

        public static void lastVisit(TreeNode root) {
            if (root == null) {
                return;
            } else {
                lastVisit(root.left);
                lastVisit(root.right);
                System.out.print(root.val + " ");
            }
        }
    }
}
