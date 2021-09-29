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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        int len = n / k;
        int mod = n % k;
        ListNode[] ans = new ListNode[k];
        ListNode pre = dummy;
        head = dummy.next;
        int i = 0;
        while (i < k) {
            ans[i] = head;            
            for (int j = 0; j < len; j++) {
                pre = head;
                head = head.next;    
            }
            if (i < mod) {
                pre = head;
                head = head.next;
            }
            pre.next = null;            
            i++;
        }
        return ans;
    }
}


/*
1. Get n the number of nodes in the list
    
2. To split the list to k parts

   n / k
   n % k 
   
   [1,2,3,4,5,6,7,8,9,10], k = 3
   n = 10;
   n / k = 3;
   n % k = 1;
   
   Split nodes into k segments, each segment has n / k nodes 
   For the first n % k segments, assign one additional node

   Make sure special case is covered : 
        a. n < k
           n / k = 0
           n % k = n
           
        b. n = 0
           n / k = 0;
           n % k = 0;
           
   Time - O(N)
   space - O(1)

*/
