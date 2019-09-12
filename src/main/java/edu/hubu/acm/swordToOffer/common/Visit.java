package edu.hubu.acm.swordToOffer.common;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Visit
 * @Description TODO
 * @createTime 2019年09月10日 17:24:00
 */
public class Visit {
    public void visit(BTree.BTreeNode node){
        System.out.print(node.getData() + " ");
    }
    public void printLine(){
        System.out.println();
    }
}
