import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List集合全排列递归实现
 */
public class ListPerRecur {

    private static List<List<Integer>> list = new ArrayList<>();
    @Test
    public void test(){
        List<Integer> array = Arrays.asList(1, 2, 3);
        getAllOrderNodes(array, 0);
        list.forEach(System.out::println);
    }
    public static void getAllOrderNodes(List<Integer> nodes, int index) {
        if (index == nodes.size() ) {
            list.add(new ArrayList<>(nodes));
            return;
        }
        for (int i = index; i < nodes.size() ; i++) {
            Collections.swap(nodes, index, i);
            getAllOrderNodes(nodes, index + 1);
            Collections.swap(nodes, index, i);
        }
    }
}
