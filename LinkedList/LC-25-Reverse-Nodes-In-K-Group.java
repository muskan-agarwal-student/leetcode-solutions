//Problem name: Reverse nodes in k-group
//Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
//Time Complexity: O(n) - as each node is visited and reversed once.
//Space Complexity: O(n/k) - due to recursion stack for every group of k.
//Why space complexity n/k? As 1 <= k <= n.

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //step1 - to check if k-nodes exist.
        ListNode temp = head;
        int cnt = 0;
        while(cnt < k){
            if(temp == null) return head;
            temp = temp.next;
            cnt++;
        }
        //step2 - recursively call for the rest of the LL after k-nodes.
        ListNode newNext = reverseKGroup(temp,k);

        //step3 - reverse the current k-node group.
        temp = head;
        cnt = 0;
        while(cnt < k){
            ListNode next = temp.next;
            temp.next = newNext;
            newNext = temp;
            temp = next;
            cnt++;
        }
        return newNext; //new head of the modified list.
    }
}
