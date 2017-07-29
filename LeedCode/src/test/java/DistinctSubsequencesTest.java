import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangyichun on 2017/7/20.
 */
public class DistinctSubsequencesTest {
    @Test
    public void numDistinct() throws Exception {

        DistinctSubsequences subsequences = new DistinctSubsequences();
        String s = "rabbbit";

        String t = "rabbit";
        int num = subsequences.numDistinct(s, t);
        Assert.assertEquals(num, 3);
    }

}