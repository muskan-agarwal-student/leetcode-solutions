//Problem name: Remove duplicates from sorted list.
//Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
//Time Complexity: O(n) as each node is visited only once.
//Space Complexity: O(1) 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //base case
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        while(curr != null){
            if((curr.next != null) && (curr.val == curr.next.val)){ //checking for duplicates
                curr.next = curr.next.next;
            }else{
                curr = curr.next; //if duplicate not found move curr one step forward
            }
        }
        return head;
    }
}
