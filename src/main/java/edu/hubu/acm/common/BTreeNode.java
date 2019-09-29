package edu.hubu.acm.common;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName BTreeNode
 * @Description 树节点类
 * @createTime 2019年09月29日 11:51:00
 */
public class BTreeNode {
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

    public BTreeNode getLchild() {
        return lchild;
    }

    public BTreeNode getRchild() {
        return rchild;
    }
}
