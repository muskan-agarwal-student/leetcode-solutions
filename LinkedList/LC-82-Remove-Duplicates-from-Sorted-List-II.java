//Problem name: Remove duplicates from sorted list II
//Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
//Time Complexity: O(n) as each node is visited only once.
//Space Complexity: O(1) as no extra data structure has been used.

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; //very important line
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            //Check for duplicate series
            if((curr.next != null) && (curr.val == curr.next.val)){
                //Move curr to the last duplicate
                while((curr.next != null) && (curr.val == curr.next.val)){
                    curr = curr.next;
                }
                //skip all duplicates
                prev.next = curr.next;
            }else{
                //safe node, move prev
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next; //skipping the dummy node as it is only for finding the head of the modified list.
    }
}
