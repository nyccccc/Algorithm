import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :希尔排序：又称为缩小增量排序
 *                      它与插入排序的不同之处在于，它会优先比较距离较远的元素
 * @create :2020-11-07
 */


public class ShellSort {
    public int[] shellSort(int[] nums){
        if ( nums.length==0 ){
            return nums;
        }
        int tmp, gap =nums.length/2;
        while ( gap>0 ){
            for ( int i =gap;i<nums.length;i++ ){
                tmp = nums[i];
                int preIndex = i-gap;
                while ( preIndex>=0&&nums[preIndex]>tmp ){
                    nums[preIndex+gap] = nums[preIndex];
                    preIndex -=gap;
                }
                nums[preIndex+gap] = tmp;
            }
            gap /=2;
        }
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = shellSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
