import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 */
public class LeetCode_23 {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        int max = 1;
        for (int i = 0; i < num.length; i++) {
            if (set.remove(num[i])) {
                int value = num[i];
                int redVal = value - 1;
                int addVal = value + 1;
                int sum = 1;
                while (set.remove(redVal)) {
                    ++ sum;
                    --redVal;
                }
                while (set.remove(addVal)) {
                    ++sum;
                    ++addVal;
                }
                max = max >= sum ? max : sum;
            }
        }
        return max;
    }
}
