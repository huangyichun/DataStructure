import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by huangyichun on 2017/6/9.
 */
public class TestLeetCode_24 {

    @Test
    public void test(){
        LeetCode_24 leetCode24 = new LeetCode_24();
        String start = "hit", end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("lot");
        dict.add("log");
        int num = leetCode24.ladderLength(start, end, dict);
        Assert.assertEquals(5, num);
    }
}
