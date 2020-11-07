import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :插入排序:
 *                      对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * @create :2020-11-07
 */


public class InsertSort {
    public int[] insertSort(int[] nums){
        if ( nums.length ==0 ){
            return nums;
        }
        int current;
        for ( int i=0; i<nums.length-1;i++ ){
            current = nums[i+1];
            int pre = i;
            while( pre>=0&&current<nums[pre]){
                nums[pre+1] = nums[pre];
                pre--;
            }
            nums[pre+1] =current;
        }
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = insertSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
