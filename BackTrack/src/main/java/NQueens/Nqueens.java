package NQueens;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :N皇后问题
 * @url :
 * @create :2020-11-14
 */

public class Nqueens {
    List<List<String>> res = new LinkedList< List< String > > ();
    public List< List<String> > solveNQueens( int n) {
        if ( n<=0 ) {
            return null;
        }
        int[] queen = new int[n];
        backtrack(queen,0);
        return res;
    }

    private void backtrack (  int[] queen, int pos ) {
        if ( pos==queen.length ){
            List<String> list = new ArrayList<String> ();
            for ( int j : queen ) {
                //sb 表示每一行的符合条件的结果
                StringBuilder stringBuilder = drawPoint (queen.length);
                stringBuilder.setCharAt (j, 'Q');
                list.add (stringBuilder.toString ());
            }
            res.add(list);
            return;
        }
        for ( int i =0;i< queen.length;i++ ){
            //循环调用从地方开始寻找符合条件的皇后的位置
            queen[pos] =i;
            /*
             * 满足条件则开始下一行的寻找
             * 不满足则返回调整第一行的位置以此来进行回溯
             */
            if ( isValid(queen,pos) ){
                backtrack ( queen, pos+1);
            }
        }
    }
    public boolean isValid(int[] queen,int pos){
        for ( int i =0;i<pos;i++ ){
            if ( queen[pos] ==queen[i] ) {
                return false;
            }
            if ( Math.abs (queen[pos]-queen[i])==Math.abs (i-pos)) {
                return false;
            }
        }
        return true;
    }
    public StringBuilder drawPoint(int n){
        StringBuilder stringBuilder = new StringBuilder ();
        for ( int i =0; i< n;i++ ){
            stringBuilder.append ('.');
        }
        return stringBuilder;
    }
    @Test
    public void test(){
        System.out.println (solveNQueens (4));
    }
}
