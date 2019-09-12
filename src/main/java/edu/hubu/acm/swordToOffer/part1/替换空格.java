package edu.hubu.acm.swordToOffer.part1;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 替换空格
 * @Description TODO
 * @createTime 2019年09月09日 21:14:00
 */
public class 替换空格 {
    public String replaceBlankSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        int lastBlankIndex = -1, nextBlankIndex;
        while ((nextBlankIndex = str.indexOf(" ", lastBlankIndex + 1)) != -1) {
            result.append(str.substring(lastBlankIndex + 1, nextBlankIndex));
            result.append("%20");
            lastBlankIndex = nextBlankIndex;
        }
        if (lastBlankIndex < str.length() - 1) {
            result.append(str.substring(lastBlankIndex + 1));
        }
        return result.toString();
    }

}
