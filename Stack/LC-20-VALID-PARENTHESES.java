//Problem name: Valid parentheses
//Problem link: https://leetcode.com/problems/valid-parentheses/description/
//TC :- O(n) as each character is visited once ; TC :- O(n) as stack data structure is used.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0 ; i<n ; i++){
          char ch = s.charAt(i);
          if(ch=='(' || ch=='{' || ch=='['){
            st.push(ch); //pushing only opening brackets
          }else{ 
            //corner case
            if(st.size()==0) return false; //the case in which closing brackets > opening brackets
            if(st.peek()=='(' && ch==')' || st.peek()=='{' && ch=='}' || st.peek()=='[' && ch==']'){ //checking opening bracket with their respective closing bracket 
                st.pop();
            }else return false;
          }
        }
      //another case in whch if stack is not empty means opening > closing brackets
        if(st.size()>0) return false;
        else return true;
    }
}
