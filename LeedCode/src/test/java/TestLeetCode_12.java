import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by huangyichun on 2017/6/6.
 */
public class TestLeetCode_12 {

    @Test
    public void test(){
        LeetCode_12 leetCode_12 = new LeetCode_12();
        String s = "leetcode";
        HashSet<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        boolean b = leetCode_12.wordBreak(s, set);
        Assert.assertEquals(b, true);
    }
}
