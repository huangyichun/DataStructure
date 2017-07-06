/**
 * 题目描述
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a ="11"
 * b ="1"
 * Return"100".
 */
public class AddBinary {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("huang");
        builder.append("yichun");

        System.out.println(builder.toString());
    }
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {//将长的字符串赋值给a
            String temp = a;
            a = b;
            b = temp;
        }
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        while(lenB >= 0) {
            int sum = a.charAt(lenA)-'0' + b.charAt(lenB) - '0' + add;
            add = sum / 2;
            sum %= 2;
            result.insert(0, sum);
            --lenA;
            --lenB;
        }

        while(lenA >= 0) {
            int sum = a.charAt(lenA) - '0' + add;
            add = sum / 2;
            sum %= 2;
            result.insert(0, sum);
            --lenA;
        }

        if(add >= 1) {
            result.insert(0, add);
        }
        return result.toString();
    }
}
