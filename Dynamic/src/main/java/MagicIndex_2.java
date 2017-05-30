import org.junit.Test;

/**
 * 题目描述
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，
 * 元素值可能相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引
 *
 * 思路:
 *      需要判定左右两边是否存在魔术索引
 *      leftIndex = Math.min(midIndex-1, midValue);
 *      rightIndex = Math.max(midIndex + 1, midValue);
 */
public class MagicIndex_2 {

    @Test
    public void test(){
        int[] array = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        findMagicIndex(array, array.length-1);
    }
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        return isFind(A, 0, n-1);
    }

    public boolean isFind(int[] array, int low, int high){
        if(low <0 || low > high || high >= array.length)
            return false;
        int midIndex = (low + high) / 2;
        int midValue = array[midIndex];
        if(midIndex == array[midIndex])
            return true;

        int leftIndex = Math.min(midIndex-1, midValue);
        boolean isLeftFind = isFind(array, low, leftIndex);
        if(isLeftFind)
            return true;
        int rightIndex = Math.max(midIndex + 1, midValue);
        boolean isRightFind = isFind(array, rightIndex, high);
        return isRightFind;
    }
}
