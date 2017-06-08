import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/8.
 */
public class TestLeetCode_21 {

    @Test
    public void test(){
        LeetCode_21 leetCode21 = new LeetCode_21();
        /*char[][] array = new char[][]{
                {'X','O','X','X'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'}
        };*/
        char[][] array1 = new char[][]{
                {'O', 'O'},
                {'O', 'O'},
        };
        leetCode21.solve(array1);
    }
}
