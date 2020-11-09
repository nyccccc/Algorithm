import org.junit.Test;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :找零问题:
 *                      假设1元、2元、5元、10元、20元、50元、100元的纸币，
 *                      张数不限制，现在要用来支付K元，至少要多少张纸币？
 * @create :2020-11-08
 */


public class GiveMoney {
    public int giveMoney(int[] money,int target){
        int res =0;
        if(money.length==0||target==0){
            return res;
        }
        for(int i =money.length-1;i>=0;i--){
            res = res+target/money[i];
            target = target%money[i];
        }
        return res;
    }
    @Test
    public void test(){
        int[] money = new int[]{1,2,5,20,50,100};
        System.out.println (giveMoney (money,2432));
    }
}
