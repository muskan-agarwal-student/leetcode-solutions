//Problem name: Merge two sorted lists.
//Problem link: https://leetcode.com/problems/merge-two-sorted-lists/description/
//Approach: RECURSIVE ==> Pick the smaller node, attach it to the result, and let recursion handle the rest.
//Time Complexity: O(m+n) where 'm' is the length of the first list and 'n' is the length of the second list.
//Space Complexity: O(m+n) due to recursion stack.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //base cases
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        //recursive step
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1; //l1 becomes head
        }else{ //list2.val > list1.val
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;  //l2 becomes head
        }
    }
}


