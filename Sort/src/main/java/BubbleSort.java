import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 冒泡排序
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] array = {1, 2,6, 3, 4, 9};
        bubbleSort(array);
        Arrays.stream(array).forEach(x-> System.out.print(x + " "));
    }

    public void bubbleSort(int[] array){
        for(int i=array.length-1; i>0; --i){
            for(int j=0; j <i; ++j){
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                }
            }
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
