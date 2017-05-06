import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List集合非递归实现
 * 1,将序列排序，生成最小序列Smin
 * 2,然后找到比Smin大但比其他序列都小的序列Smin+1
 * 3,反复执行2,直到序列最大
 * 比如序列{2,1,3}，首先排序得到最小序列{1,2,3}，然后找到次小的序列{1,3,2}，然后是{2,1,3}……以此类推直到序列{3,2,1}结束。
 *
 * 其算法是在序列{s0,s1,…si,sj,…sk,…,sn-1}中
 * 1,从后向前查找,找到第一个si<sj,如果i=0时依然没有找到，说明该序列已经最大，返回。
 * 2,从后向前查找，找到第一个比si大的元素sk，交换si和sk。为了保证得到的是次小的序列，将序列si+1到sn-1逆向。
 * 3,重复1、2两步直到退出
 */
public class ListPerNoRecur {


    private static List<List<Integer>> lists = new ArrayList<>();

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        getAllOrderList(list);
        lists.forEach(System.out::println);
    }


    public static void getAllOrderList(List<Integer> nodes){
        Collections.sort(nodes);//按照自然顺序排列
        int length = nodes.size();
        int i,j;
        while(true){
            i = length - 1;//每次循环完成后重置i的值
            j = i;
            lists.add(new ArrayList<>(nodes));
            while(i >= 0 && nodes.get(i) >= nodes.get(j)){
                if(j == i){
                    -- i;
                    j = length-1;
                }else {
                    --j;
                }
            }
            if(i <0)
                return;
            Collections.swap(nodes, i, j);
            reverseOrder(nodes, i+1, length-1);
        }
    }

    private static void reverseOrder(List<Integer> nodes,int start, int last){
        while(start < last){
            int tmp = nodes.get(start);
            nodes.set(start, nodes.get(last));
            nodes.set(last,tmp);
            ++start;
            --last;
        }
    }
}
