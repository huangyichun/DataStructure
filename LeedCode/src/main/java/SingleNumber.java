/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * Single Number的本质，就是用一个数记录每个bit出现的次数，
 * 如果一个bit出现两次就归0，这种运算采用二进制底下的位操作^是很自然的。
 * Single Number II中，如果能定义三进制底下的某种位操作，
 * 也可以达到相同的效果，Single Number II中想要记录每个bit出现的次数，
 * 一个数搞不定就加两个数，用ones来记录只出现过一次的bits，
 * 用twos来记录只出现过两次的bits，ones&twos实际上就记录了出现过三次的bits，
 * 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
 */
public class SingleNumber {
    public int singleNumber_2(int[] A) {

        int[] bitNume = new int[32];
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < A.length; ++j){
                bitNume[i] += (A[j] >> i) & 1;
            }
            res += (bitNume[i] % 3) << i;
        }
        return res;
    }
    public int singleNumber(int[] A) {

        int one = 0, two = 0, three = 0;
        for (int i = 0; i < A.length; ++i) {
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
