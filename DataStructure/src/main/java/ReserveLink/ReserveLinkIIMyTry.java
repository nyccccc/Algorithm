package ReserveLink;

/**
 * @author : YiChen Niu (yniu7@sheffield.ac.uk)
 * @version : 0.1
 * @program :Algorithm
 * @description :翻转链表2
 * @url :https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @create :2020-11-14
 */


public class ReserveLinkIIMyTry {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       if ( m==1 ){
           return reverseN(head,n);
       }
       head.next = reverseBetween (head,m-1,n-1);
       return head;
    }
    ListNode behind = null;
    ListNode reverseN(ListNode head,int n){
        if ( n==1 ){
            behind = head.next;
            return head;
        }
        ListNode last = reverseN (head.next,n-1);
        head.next.next=head;
        head.next =behind;
        return last;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }
}
