package edu.hubu.acm.swordToOffer.common;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName BTree
 * @Description TODO
 * @createTime 2019年09月10日 17:21:00
 */
public class BTree {
    /**
     * 树节点类
     * 这里用二叉链表，存储
     *
     * @author Administrator
     */
    class BTreeNode {
        private Object data;
        private BTreeNode lchild;
        private BTreeNode rchild;

        public BTreeNode() {
            lchild = null;
            rchild = null;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setLchild(BTreeNode lchild) {
            this.lchild = lchild;
        }

        public void setRchild(BTreeNode rchild) {
            this.rchild = rchild;
        }

        public Object getData() {
            return data;
        }
    }

    //下面是二叉树的一些属性
    private Object array[];//用数组保存所有树节点的数据
    private BTreeNode root;//根节点
    private Visit visit = new Visit();//java 不能将函数作为函数的参数，用一个类封装方法

    /**
     * 构造一棵树，指向根节点
     *
     * @param array
     */
    public BTree(Object array[]) {
        this.array = array;
        root = build(1);
    }

    /**
     * 根据成员变量array[]递归构造一棵树
     * 构造左子树、右子树
     *
     * @return
     */
    public BTreeNode build(int i) {
        int n = array.length;

        if (i <= n) {//i在数组内，说明可以构造一个以array[i]为根节点的子树
            BTreeNode treeNode = new BTreeNode();
            treeNode.setData(array[i - 1]);//设置根节点
            treeNode.setLchild(build(2 * i));//构造左子树
            treeNode.setRchild(build(2 * i + 1));//构造右子树
            return treeNode;
        } else {
            return null;
        }
    }

    /**
     * 获取树的所有节点的个数
     */
    public int getNodeNum() {
        return getNodeNum(root);
    }

    /**
     * 计算所有节点的个数
     * 递归实现，左子树个数 + 右子树个数 + 1
     *
     * @param root
     * @return
     */
    public int getNodeNum(BTreeNode root) {
        if (null == root)
            return 0;
        else {
            return getNodeNum(root.lchild) + getNodeNum(root.rchild) + 1;
        }

    }

    /**
     * 获取树的高度
     *
     * @return
     */
    public int getDep() {
        return getDep(root);
    }

    /**
     * 获取树的高度
     * 递归获取左右子树的高度，返回最高的那个
     * root为空，返回0，说明为空树，高度为0
     * 如果不为空，左子树和右子树高度较大值 +1为树的高度
     *
     * @param root
     * @return
     */
    public int getDep(BTreeNode root) {
        if (null == root)
            return 0;//空树返回0，高度为0，也是函数的出口
        else {
            int max = getDep(root.lchild);//获取左子树的高度
            if (max < getDep(root.rchild))
                max = getDep(root.rchild);//获取右子树高度，并和左子树比较

            return max + 1;//因为不为空树，树的高度为左右子树高度的最大值 + 1
        }

    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历树，先遍历根节点，在遍历左节点，右节点
     *
     * @param root
     */
    public void preOrder(BTreeNode root) {
        if (null != root) {
            visit.visit(root);
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历，县遍历左子树，根，最后遍历右子树
     * 递归实现
     *
     * @param root
     */
    public void inOrder(BTreeNode root) {
        if (null != root) {
            inOrder(root.lchild);
            visit.visit(root);
            inOrder(root.rchild);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历，先遍历左子树，右子树和根节点
     * 这也用递归实现
     *
     * @param root
     */
    public void postOrder(BTreeNode root) {
        if (null != root) {//这里可以看成递归的出口
            postOrder(root.lchild);
            postOrder(root.rchild);
            visit.visit(root);
        }
    }

    public static void test() {
        Visit visit = new Visit();
        Character array_ch[] = new Character[]{'-', '*', 'c', 'a', 'b'};
        BTree tree = new BTree(array_ch);
        //前序、中序和后序遍历
        tree.preOrder();
        visit.printLine();
        tree.inOrder();
        visit.printLine();
        tree.postOrder();
        visit.printLine();
        //获取节点数和树的深度
        System.out.println(tree.getNodeNum());
        System.out.println(tree.getDep());
    }

}
