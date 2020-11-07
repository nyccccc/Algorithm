import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :选择排序
 * @create :2020-11-07
 */


public class SelectSort {
    public int[] selectSort(int[] nums){
        if ( nums.length==0 ){
            return nums;
        }

        for ( int i =0;i<nums.length-1;i++ ){
            int minIndex =i;
            for ( int j =i+1;j<nums.length;j++ ){
                if ( nums[minIndex]>nums[j] ){
                    minIndex=j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = selectSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
