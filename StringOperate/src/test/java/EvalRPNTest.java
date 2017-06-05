import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/5.
 */
public class EvalRPNTest {
    EvalRPN evalRPN;
    @Before
    public void init(){
        evalRPN = new EvalRPN();
    }
    @Test
    public void testInputTrueString(){
        String[] strings1 = {"2", "1", "+", "3", "*"};
        String[] strings2 = {"4", "13", "5", "/", "+"};
        int sum1 = evalRPN.evalRPN(strings1);
        int sum2 = evalRPN.evalRPN(strings2);

        Assert.assertEquals(sum1, 9);
        Assert.assertEquals(sum2, 6);

    }
}
