//Problem name: Swap nodes in pairs
//Problem link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
//Time Complexity: O(n), since each node is visted once.
//Space Complexity: O(1) , as only pointers are used no extra data structures are used.

class Solution {
    public ListNode swapPairs(ListNode head) {
        //edge cases
        if(head == null || head.next == null){
            return head;
        }
        //three pointers to perform swap
        ListNode prev = null;
        ListNode first = head;
        ListNode sec = head.next;
        while(first != null && sec != null){
            //performing the swap
            ListNode third = sec.next;//third pointer to store the address of list after breaking the connection of second node.
            sec.next = first;
            first.next = third;

            if(prev != null){
                prev.next = sec;
            }else{
                head = sec;
            }
           //Updating pointers for further list
           prev = first;
           first = third;
           //check for updating second value
           if(third != null){
                sec = third.next;
           }else{
                sec = null;
           }
        }
        //returning the new head of the list
        return head; 
    }
}
