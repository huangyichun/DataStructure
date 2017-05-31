import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 编写一个方法，确定某字符串的所有排列组合。
 * 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 * 保证字符串长度小于等于11且字符串中字符均为大写英文字符，
 * 排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 */
public class Permutation {
    @Test
    public void test() {
        List<String> list = getPermutation("AAC");
        System.out.println(list
        );
    }

    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> getPermutation(String A) {
        // write code here
        char[] chars = A.toCharArray();
        permutation(chars, 0);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return list;
    }

    /**
     * 通过交换完成全排列,可以去重
     * @param chars
     * @param index
     */
    public void permutation(char[] chars, int index) {
        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (i != index && chars[i] == chars[index])
                continue;
            swap(chars, index, i);
            permutation(chars, index + 1);
            swap(chars, index, i);
        }
    }

    /**
     * 交换字符数组位置
     *
     * @param chars
     * @param i
     * @param j
     */
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
