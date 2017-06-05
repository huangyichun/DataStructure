import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,
 * 子集之间字典逆序排序，见样例。
 *
 * 组合算法
 * p(0) = {}
 * p{1} = {} {a1}
 * p{2} = {} {a1} {a2} {a1, a2}
 * p{3} = {} {a1} {a2} {a1, a2} {a3} {a1, a3} {a2, a3} {a1, a2, a3}
 *
 * p{3} = p{2} + [p{2} + a3]
 */
public class Subset {

    @Test
    public void test() {
        int[] A = {3, 2, 1, 4};
        ArrayList<ArrayList<Integer>> lists = getSubsets(A, A.length);
        System.out.println(lists);
    }

    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // 保存组合后的集合
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<ArrayList<Integer>> copyList = new ArrayList<>();
            for (ArrayList<Integer> arrayList : lists) {
                copyList.add(new ArrayList<>(arrayList));
            }
            for (ArrayList<Integer> arrayList : copyList) {
                arrayList.add(A[i]);
                lists.add(arrayList);
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(A[i]);
            lists.add(arrayList);
        }

        for (ArrayList<Integer> arrayList : lists) {
            Collections.sort(arrayList, (o1, o2) -> o2.compareTo(o1));
        }

        Collections.sort(lists, (o1, o2) -> {
            for (int i = 0; i < o1.size() && i < o2.size(); i++) {
                if (o1.get(i) < o2.get(i))
                    return 1;
                else if (o1.get(i) > o2.get(i))
                    return -1;
            }
            return o2.size() - o1.size();
        });
        return lists;
    }
}
