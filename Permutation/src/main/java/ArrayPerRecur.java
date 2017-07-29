import java.util.Arrays;

/**
 * 数组全排列
 */
public class ArrayPerRecur {

    public static void main(String[] args) {
        ArrayPerRecur perRecur = new ArrayPerRecur();
        int[]  array = new int[] {1, 2, 2,4};
        perRecur.permutation(array, 0);
    }

    public void permutation(int[] array, int start){

        if (start >= array.length) {
            Arrays.stream(array).forEach((x)-> System.out.print(x+" "));
            System.out.println();
            return;
        }

        for (int i = start; i < array.length; ++i) {
            if (start != i && array[start] == array[i]){
                continue;
            }else {
                swap(array, start, i);
                permutation(array, start + 1);
                swap(array, start, i);
            }
        }
    }

    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
