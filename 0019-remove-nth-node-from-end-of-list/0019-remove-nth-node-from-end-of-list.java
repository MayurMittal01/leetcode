/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        curr = head;
        int position = count - n+1;
        if(position==1){
            return head.next;
        }
        for(int i =1; i<position-1;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}