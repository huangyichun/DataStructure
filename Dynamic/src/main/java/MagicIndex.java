/**
 * 题目描述
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，
 * 元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 *
 * 思路:二分查找
 */
public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        int low = 0, high = n -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A[mid] == mid)
                return true;
            else if(A[mid] > mid){
                high = mid - 1;
            }else
                low = mid + 1;
        }

        return false;
    }
}
