/**
 * 题目描述
 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 */
public class Reverse {
    public String reverseString(String iniString) {
        // write code here
        if(iniString == null || iniString.length() == 0)
            return "";

        int i=0, j=iniString.length()-1;
        StringBuilder sb = new StringBuilder(iniString);
        while(i<j){
            char temp = iniString.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            ++i;
            --j;
        }
        return sb.toString();
    }
}
