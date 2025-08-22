//Problem: Middle of the Linked List.
//Link: https://leetcode.com/problems/middle-of-the-linked-list/
//Approach: Two-pointer method (slow and fast pointers)

public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
