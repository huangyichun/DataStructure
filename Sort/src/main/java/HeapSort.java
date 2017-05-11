import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort<T extends Comparable> {

    @Test
    public void test(){
        HeapSort<Integer> heapSort = new HeapSort<>();
        Integer[] array = {5,7,8,9,10,3,22,4,7};
        heapSort.heapSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
    /**
     * 一次调整
     * @param array  调整的数组
     * @param start 调整的节点
     * @param end  数组最后一个下标
     */
    public void adjust(T[] array, int start, int end){
        T temp = array[start];//要调整的节点
        int next = start * 2 + 1;
        while(next <= end){
           if(next + 1 <= end && array[next + 1].compareTo(array[next]) < 0)//找出子节点中最小的一个节点
               ++ next;
            if(array[next].compareTo(temp) > 0)
                break;
            array[start] = array[next];
            start = next;
            next = next * 2 + 1;
        }
        array[start] = temp;
    }

    public void heapSort(T[] array){
        int index = (array.length - 1) / 2;
        for(int i= index; i>=0; --i)
            adjust(array, i, array.length-1);

        for(int i=array.length-1; i>0; --i){
            T temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjust(array, 0, i-1);
        }
    }


}
