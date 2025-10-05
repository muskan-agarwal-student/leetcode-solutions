//Problem name: LRU Cache
//Problem link: https://leetcode.com/problems/lru-cache/description/
//Time Complexity: O(1)  ; Space Complexity: O(limit)
class LRUCache {

    class Node{
     int key, value;
     Node next;
     Node prev;

     Node(int k, int v){
        key = k;
        value = v;
        next = prev = null;
     }    
    }
    HashMap<Integer,Node> map = new HashMap<>();
    int limit;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    void addNode(Node newnode){
        //making a node type pointer to store the address of head's next.
        Node oldnext = head.next;
        //making four connections to add a node
        head.next = newnode;
        oldnext.prev = newnode;
        newnode.next = oldnext;
        newnode.prev = head;
    }
    void delNode(Node oldnode){
        //making two pointers before and after the oldnode
        Node oldprev = oldnode.prev;
        Node oldnext = oldnode.next;
        
        oldprev.next = oldnext;
        oldnext.prev = oldprev;
    } 
    public LRUCache(int capacity){
      limit = capacity;
      head.next = tail;
      tail.prev = head; 
    }
    public int get(int key) {
        if(map.containsKey(key) == false){ //key doesn't exist
            return -1;
        }
        int ans = map.get(key).value;//storing the value inside the node in a integer-type variable

        Node ansnode = map.get(key);
        //removing the pair and again adding it to make it most recently used data
        map.remove(key);
        delNode(ansnode);
        addNode(ansnode);
        map.put(key,ansnode);

        return ans;
    }
    public void put(int key, int value) {
        //edge cases
        if(map.containsKey(key) == true){ //means key already exists
         Node oldNode = map.get(key);
         delNode(oldNode);
         map.remove(key);
       }
       if(map.size() == limit){ //delete LRU data before the tail
         map.remove(tail.prev.key);
         delNode(tail.prev);
       }
       //now adding a node inside a doubly linked-list 
       Node newnode = new Node(key,value);
        addNode(newnode);
        map.put(key,newnode);
    }
}
