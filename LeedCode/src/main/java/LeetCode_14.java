/**
 * Given an array of integers, every element appears twice
 * except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class LeetCode_14 {
    public int singleNumber(int[] A) {
        int sigle = 0;

        for (int i = 0; i < A.length; ++i){
            sigle ^= A[i];
        }
        return sigle;
    }
}
