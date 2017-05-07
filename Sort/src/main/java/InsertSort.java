import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    @Test
    public void test(){
        int[] array = {3, 1, 4, 2, 7, 6};
        insert(array);
        Arrays.stream(array).forEach(System.out::print);
    }
    public static void insert(int[] array){
        if(array==null || array.length == 0)
            return;

        for(int i=1; i<array.length; i++){
            int j=i-1;
            //找到前i个中第一个小于等于i的数的前一个
            while(j >=0 && array[j] > array[i])
                --j;
            int temp = array[i];//保存第i个数
            for(int k=0; k<i-j-1; k++){//将数组后移
                array[i-k] = array[i-k-1];
            }
            array[j+1] = temp;
        }
    }
}
