//Problem name: Linked List Cycle 2
//Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/description/
//Approach:- 1) Floyd's Cycle Detection Algorithm(Tortoise and Hare).
// -Initialize two pointers: slow(1 step) amd fast(2 steps).
// -Move them until they meet --> confirms that there is a cycle or not.

//2) Once cycle is detected: place slow pointer at the head again and move them by one-one step.
// -The point where they meet again is the start of the cycle.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;     
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){ //cycle detected
          isCycle = true;
          break;
        }
      }
      if(isCycle == false){
        return null;
      }
      slow = head; //procedure to find the cycle node
      while(slow != fast){
        slow = slow.next;
        fast = fast.next;
      }
      return slow; //node found from which cycle begins also we can return fast in-place of slow, optional
    }
}


  
