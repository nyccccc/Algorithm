import org.junit.jupiter.api.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Code
 * @description :冒泡排序
 *              最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * @create :2020-11-07
 */


public class MaoPao {
    public int[] MaoPao(int[] nums){
        //如果为空返回为空
        if ( nums.length==0 ){
            return nums;
        }

        //i 取值为nums.length-1 表示排位到倒数第二个数值
        for ( int i =0; i< nums.length-1;i++ ){
            for ( int j=i+1; j< nums.length;j++ ){
                //交换函数
                if ( nums[i]<nums[j] ){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }
    @Test
    public void test(){
        int nums[] = new int[]{34,323,432,2,4344,342};
        nums = MaoPao (nums);
        for ( int a : nums ){
            System.out.println (a);
        }
    }

}
