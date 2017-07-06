/**
 * 题目描述
 * Validate if a given string is numeric.
 * Some examples:
 * "0"=>true
 * " 0.1 "=>true
 * "abc"=>false
 * "1 a"=>false
 * "2e10"=>true
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 *
 * 判断是否是数字:
 *
 *  +/-num.num E/e -/+ 正整数  +9.1e+03; +9.E+03;
 * 1. 首先是空格，去除开始空格和结尾空格
 * 2. 过滤 +/-符号 该符号只能出现在开始和 e/E 之后
 * 3. 小数点 .只能出现一个且小数点必须出现在e/E之前
 * 4. e/E 只能出现一个，如果e/E之前
 * 错误: e9 / .e8
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        validNumber.isNumber("005047e+6");
    }
    public boolean isNumber(String s) {
        int i = 0;
        int len = s.length() - 1;
        while(i <= len && Character.isSpaceChar(s.charAt(i))) ++i; //去除开头空格
        while(i <= len && Character.isSpaceChar(s.charAt(len))) --len; //去除结尾空格
        if(i > len){
            return false;
        }
        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i; //去除开头的+/-
        while (i <= len) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                digit = true;
            }else if(c == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            }else if(c == 'e' || c == 'E'){
                if (exp || !digit) return false;
                exp = true;
                digit = false;
            }else if (c == '+' || c  == '-'){
                if (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }else {
                return false;
            }
            ++i;
        }
        return digit;
    }
}
