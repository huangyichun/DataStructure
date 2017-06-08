import org.junit.Assert;
import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/8.
 */
public class TestLeetCode_19 {

    @Test
    public void testAABShouldInput1(){

        String s = "aabcba";
        LeetCode_19 leetCode_19 = new LeetCode_19();
        int num = leetCode_19.minCut(s);
        Assert.assertEquals(1, num);
    }
}
