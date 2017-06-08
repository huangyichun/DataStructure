import java.util.ArrayList;

/**
 * 给我们一个字符串，求出所有这个字符串的子串，
 * 并且子串都为回文字符串的情况，输出它的集合结果
 *
 * 思路:
 * str1 = str.substr(0, i); 取出前面下标从 0 开始到 i 结束的子串，判断str1是否满足回文字符串的要求，
 * 1. 满足：这样子，有可能成为一种分割的情况，所以我们new出一个list集合，把str1放入到list中，
 * 然后我们求出str剩余的子串  str2 = str.substr(i);  取出前面下标从 i 开始到整个字符串结尾的子串，
 * 然后将str2 作为新的字符串，同时把list集合也传入到函数中，递归调用。
 * 递归的结束条件就是到传入的这个字符串的长度为0（这样就意味着已经到了字符串的末尾了），
 * 此时证明这种情况下得到的list集合是满足条件的，我们把这个list集合 加入到 结果集合result中。
 *
 * 2. 不满足的话，继续 i++， 直到 i == str.length();
 *
 * 3. 全部结束之后，返回 最终的结果集合 result
 */
public class LeetCode_20 {

    private ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String s) {
        calResult(new ArrayList<>(), s);
        return result;
    }

    public void calResult(ArrayList<String> list, String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        int len = s.length();
        for (int i = 1; i <= len; ++i) {
            String subStr = s.substring(0, i);
            if (checkIsPalindrome(subStr)) {
                list.add(subStr);
                calResult(list, s.substring(i));
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean checkIsPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int start = 0, end = s.length() - 1; start < end; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
