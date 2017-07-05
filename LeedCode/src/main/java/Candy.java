/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * 思路：左右分别扫描
 */
public class Candy {

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i=0; i<ratings.length - 1; ++i) {
            if (ratings[i + 1] > ratings[i]) {
                res[i + 1] = res[i] + 1;
            }else {
                res[i + 1] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i-1] > ratings[i] && res[i - 1] < res[i]) {
                res[i - 1] = res[i] + 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; ++i) {
            sum += res[i];
        }
        return sum;
    }
}
