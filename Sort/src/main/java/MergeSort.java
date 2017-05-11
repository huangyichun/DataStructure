import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序算法
 */
public class MergeSort {

    private int[] copy;

    @Test
    public void test(){
        int[] array = {3, 4, 2, 1, 7, 9};
        sort(array);
        Arrays.stream(array).forEach(x-> System.out.print(x+" "));
    }

    public void sort(int[] array){
        copy = new int[array.length];
        sort(array, 0, array.length-1);
    }

    public void sort(int[] array, int low, int high){
        if(low >= high)
            return;
        int mid = (high + low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid ,high);
    }

    public void merge(int[] array, int low, int mid, int high){
        int i= low, j = mid + 1;
        for(int k =low; k <= high; ++k){
            copy[k] = array[k];
        }
        int k= low;
        while(i <= mid && j <= high){
            if(copy[i] <= copy[j])
                array[k++] = copy[i++];
            else
                array[k++] = copy[j++];
        }
        while(i <= mid){
            array[k++] = copy[i++];
        }
        while(j <= high)
            array[k++] = copy[j++];
    }
}
