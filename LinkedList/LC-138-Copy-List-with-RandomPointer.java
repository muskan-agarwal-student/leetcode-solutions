//Problem name: Merge Two Sorted Lists
//Problem Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
//Time Complexity: O(n) for traversing the list twice but constants are ignored.
//Space Complexity: O(n) for using hashmap as extra space.

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node,Node> m = new HashMap<>();
        Node curr = head;
        while(curr != null){
            m.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node clone = m.get(curr);
            clone.next = m.get(curr.next);
            clone.random = m.get(curr.random);
            curr = curr.next;
        }
        return m.get(head);
    }
}
