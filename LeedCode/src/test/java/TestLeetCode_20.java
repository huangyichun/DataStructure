import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by huangyichun on 2017/6/8.
 */
public class TestLeetCode_20 {

    @Test
    public void test(){
        LeetCode_20 leetCode20 = new LeetCode_20();
        String s = "cbbbcc";
        ArrayList<ArrayList<String>> list = leetCode20.partition(s);
        list.forEach(x ->{
            x.forEach(y->System.out.print(y+" "));
            System.out.println();
        });
    }
}
