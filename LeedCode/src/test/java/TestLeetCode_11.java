import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by huangyichun on 2017/6/6.
 */
public class TestLeetCode_11 {

    @Test
    public void test() {
        LeetCode_11 leetCode_11 = new LeetCode_11();
        String s = "catsanddog";
        HashSet<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        ArrayList<String> list = leetCode_11.wordBreak(s, set);
        list.forEach(System.out::println);
    }
}
