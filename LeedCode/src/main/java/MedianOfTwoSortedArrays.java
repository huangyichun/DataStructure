/**
 * 两个有序数组求中位数
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = new int[]{1};
        int[] B = new int[] {1};
        double num = findMedianSortedArrays(A, B);
        System.out.println(num);
    }
    public static double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return getKthNum(A, 0, B , 0, len / 2 + 1);
        }else {
            return (getKthNum(A, 0, B , 0, len / 2 ) + getKthNum(A, 0, B , 0, len / 2 + 1)) / 2.0;
        }
    }

    public static int getKthNum(int[] A, int start_A, int[] B, int start_B, int k) {
        if (start_A >= A.length) {
            return B[start_B + k -1];
        }
        if (start_B >= B.length){
            return A[start_A + k -1];
        }
        if (k == 1) {
            return Math.min(A[start_A], B[start_B]);
        }
        int A_key = start_A + k / 2 - 1 < A.length ? A[start_A + k / 2 -1] : Integer.MAX_VALUE;
        int B_key = start_B + k / 2 - 1 < B.length ? B[start_B + k / 2 - 1] : Integer.MAX_VALUE;

        if (A_key < B_key) {
            return getKthNum(A, start_A + k / 2, B, start_B, k - k / 2);
        }else{
            return getKthNum(A, start_A, B, start_B + k / 2, k - k /2);
        }
    }
}
