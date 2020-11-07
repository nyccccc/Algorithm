import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :堆排序
 * @create :2020-11-07
 */


public class HeapSortByNyc {
    static  int len;
    public int[] heapSort(int[] nums){
        len = nums.length;
        if ( len<1 ){
            return nums;
        }
        buildMaxHeap(nums);
        //循环将堆的首位最大值与某位交换，然后重新调整堆
        while ( len>0 ){
            int tmp = nums[0];
            nums[0] = nums[len-1];
            nums[len-1] =tmp;
            len--;
            adjustHeap (nums,0);
        }
        return nums;
    }

    private void buildMaxHeap ( int[] nums ) {
        //从最后一个非叶子结点开始向上构造最大堆
        for ( int i = (len/2 -1);i>=0;i-- ){
            adjustHeap(nums,i);
        }
    }
    private void adjustHeap(int[] nums,int i){
        int maxIndex =i;
        //如果有左子树，且左子树大于父节点，将最大的指针指向左子树
        if ( i*2 <len&&nums[i*2]>nums[maxIndex] ){
            maxIndex = i*2;
        }
        //如果有右子树，且右子树大于父节点，将最大指针指向右子树
        if ( i*2+1<len&&nums[i*2+1]>nums[maxIndex] ){
            maxIndex=i*2+1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并递归挑战与父节点的交换的位置
        if ( maxIndex !=i ){
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] =tmp;
            adjustHeap (nums,maxIndex);
        }
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = heapSort (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }
}
