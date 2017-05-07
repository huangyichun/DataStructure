import org.junit.Test;

import java.util.Arrays;

/**
 *希尔排序
 */
public class ShellSort {

    @Test
    public void test(){

        int[] array = {5, 2, 3, 4, 5,1, 2, 8, 9,10,2,5,7,6};
        shellSort(array);
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }
    public static void shellSort(int[] array){
        int n = array.length;
        int h = 1;
        while(h <n / 3) h= h * 3 + 1;
        while(h >= 1){
            for(int i=h; i<n; ++i){
                for(int j=i; j >=h && array[j] < array[j-h]; j=j-h){
                    int temp = array[j];
                    array[j] = array[j-h];
                    array[j-h] = temp;
                }
            }
            h /= 3;
        }
    }
}
