import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :快速排序
 *               基本思想：通过一趟排序将待排记录分隔成独立的两部分，
 *                       其中一部分记录的关键字均比另一部分的关键字小，
 *                       则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * @create :2020-11-07
 */


public class QuickSort {
    public int[] quickSort(int[] nums,int start,int end){
        if ( start>end ){
            return nums;
        }
        int i =start;
        int j = end;
        int pivot = nums[i];
        while ( i<j ){
            while ( i<j&&nums[j]>=pivot ){
                j--;
            }
            if ( i<j ){
                nums[i++]= nums[j];
            }
            while ( i<j&&nums[i]<pivot ){
                i++;
            }
            if ( i<j ){
                nums[j--]=nums[i];
            }
        }
        nums[i]=pivot;
        quickSort (nums,start,i-1);
        quickSort (nums,i+1,end);
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = quickSort (nums,0,nums.length-1);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
