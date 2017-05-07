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

        for(int i=0; i<array.length; i++){
            for(int j=i; j>=1; --j){
                if(array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
