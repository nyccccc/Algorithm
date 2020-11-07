import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :归并排序
 * @create :2020-11-07
 */


public class MergeSort {
    public int[] MergeSort(int[] array) {
        if (array.length < 2){
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    public int[] merge(int[] left,int[] right){
        int[] res = new int[left.length+right.length];
        for ( int index =0, i =0, j=0; index<res.length;index++ ){
            if ( i>=left.length ){
                res[index] = right[j++];
            }else if(j>=right.length){
                res[index] = left[i++];
            }else if ( left[i]>right[j] ){
                res[index] = right[j++];
            }else {
                res[index] = left[i++];
            }
        }
        return res;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = MergeSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }


}
