//Problem name: Detect cycle in a linked list
//Problem link: https://leetcode.com/problems/linked-list-cycle/description/
//Approach: Floyd's Cycle Detection(Tortoise and Hare) ==> two pointer used(slow and fast).
//Time Complexity: O(n)
//Space Complexity: O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
          if(slow == fast){
            return true;
          }
        }
      return false;
    }
}
