//Problem name: Reverse a Linked List
//Problem link: https://leetcode.com/problems/reverse-linked-list/description/
//Approach: Iterative approach using three pointers(prev,curr,next)
//Time Complexity: O(n) ; Space Complexity: O(1)

 public ListNode reverseList(ListNode head) {
       ListNode temp = null;
       ListNode prev = null;
       ListNode curr = head;
       while(curr != null){
        temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
       }
       return prev; //now head of the reversed list 
    }
