import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List集合全排列递归实现
 *
 * 思路:通过交换两个数组位置实现全排列
 *
 * 假设 1 , 2 , 3 ， 4
 *
 * 设置一个值index 表示交换的位置
 *
 * index 初始为0，表示从1这个位置开始，与后面的进行交换
 * 如:  1, 2 ,3, 4
 *      2, 1, 3, 4
 *      3, 2, 1, 4
 *      4, 2, 3, 1
 *  下一个全排列是从 index = 1， 到数组结束位置
 *  同样是与1进行交换
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
