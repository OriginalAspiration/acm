package edu.hubu.acm.swordToOffer.part1;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 二维数组中的查找
 * @Description TODO
 * @createTime 2019年09月09日 21:12:00
 */
public class 二维数组中的查找 {
    public boolean matrixFind(int target, int[][] array) {
        boolean exist = false;
        if (array == null) {
            return exist;
        } else {
            int rows = array.length, cols = array[0].length;
            for (int row = rows - 1, col = 0; row >= 0 && col < cols; ) {
                if (target == array[row][col]) {
                    return exist = true;
                } else {
                    if (target > array[row][col]) {
                        ++col;
                    } else {
                        --row;
                    }
                }
            }
            return exist;
        }
    }

}
