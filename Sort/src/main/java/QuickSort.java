import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    @Test
    public void test(){
        int[] array = {5, 2, 3, 4, 5,1, 2, 8, 9,10,2,5,7,6};
        quickSort(array,0, array.length-1);
        Arrays.stream(array).forEach(x->System.out.print(x+" "));
    }

    public void quickSort(int[] array, int low, int high){
        if(low >= high)
            return;
        int i=low, j = high, temp = array[low];

        while(i < j){
            while(i <j && temp <= array[j])
                --j;
            array[i] = array[j];
            while(i< j && array[i] <= temp)
                ++i;
            array[j] = array[i];
        }
        array[i] = temp;
        quickSort(array, low, i-1);
        quickSort(array, i+1, high);
    }
}
