//Problem name: Next greater element I
//Problem link: https://leetcode.com/problems/next-greater-element-i/description/
//Time Complexity: O(nums1.length+nums2.length) as nums1 is processed to find results for it and nums2 is because it is processed to 
//make a map and each element is pushed and popped once.
//Space Complexity: O(n) for using stacka and hashmap(auxillary space).

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> m = new HashMap<>();
        int[] ans = new int[nums1.length]; //array to store next greater for elements 

        //finding the next greater immediate elements for nums 2 and storing in hashmap as a value and is the element itself
        for(int i = nums2.length-1 ; i>=0 ; i--){
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){ //np next greater element for the current element
                m.put(nums2[i],-1);
            }else{//next greater element occurs 
                m.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        //initializing ans array of next greater immediate element for nums1's elements using the map
        for(int i = 0 ; i < nums1.length ; i++){
            ans[i] = m.get(nums1[i]);
        }
        return ans;
    }
}
