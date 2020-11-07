import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Alogrithm
 * @description :计数排序
 * @create :2020-11-07
 */


public class CountingSort {
    public int[] countingSort(int[] nums){
        if ( nums.length==0 ){
            return  nums;
        }
        int bias, min = nums[0], max=nums[0];
        for ( int i =1; i< nums.length;i++ ){
            if(nums[i]>max){
                max = nums[i];
            }
            if ( nums[i]<min ){
                min = nums[i];
            }
        }
        bias = 0-min;
        int[] bucket = new int[max-min+1];
        Arrays.fill (bucket,0);
        for ( int i =0;i<nums.length;i++ ){
           bucket[nums[i]+bias]++;
        }
        int index =0; int i =0;
        while ( index<nums.length ){
            if ( bucket[i]!=0 ){
                nums[index] = i-bias;
                bucket[i]--;
                index++;
            }else{
                i++;
            }
        }
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,4,0,26,2,4344,342};
        nums = countingSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
