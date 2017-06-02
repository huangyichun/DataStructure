/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串重点空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否
 * 重新排列后可相同。保证两串的长度都小于等于5000。
 *
 * 思路:先判断字符串长度，后判断每个字符个数是否相同
 */
public class Same {

    public boolean checkSam(String stringA, String stringB) {

        if(stringA.length() != stringB.length())
            return false;

        int[] letter = new int[256];

        for(int i=0; i<stringA.length(); ++i){
            ++letter[stringA.charAt(i)];
        }

        for(int i=0; i<stringB.length(); ++i){
            --letter[stringB.charAt(i)];
            if(letter[stringB.charAt(i)] < 0)
                return false;
        }
        return true;

    }
}
