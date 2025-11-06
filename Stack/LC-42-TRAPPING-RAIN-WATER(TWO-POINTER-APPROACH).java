//Problem name: Trapping rain water
//Problem link: https://leetcode.com/problems/trapping-rain-water/description/
//Approach: Two pointer approach (not stack-based).
//Time Complexity : O(n) as each index is visited once.
//Space Complexity : O(1) as only extra variables are used.

//NOTE :
//This problem is categorized under "Stack" because one of the solutions uses a stack.
//Here , a more optimized and best two pointer approach is used.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int l = 0 , r = n-1;
        int lmax = 0 , rmax = 0;

        while(l < r){
            lmax = Math.max(lmax , height[l]);
            rmax = Math.max(rmax , height[r]);

            if(lmax < rmax){
                ans += lmax - height[l];
                l++;
            }else{
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }
}
