//Problem name: Min Stack
//Problem link: https://leetcode.com/problems/min-stack/description/
//TC:- O(n) using 2 for loops and one while loop as while loop is eliminating one element at a time and pushing two elements so overall n elements.
//SC:- O(n) for using stcak data structure.

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt; //stack for storing updated minimum element

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);//only push the value inside min stack when the incoming value is less than the value at the top of the min stack.
        }
    }
    public void pop() {
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();//only pop the value from min stack when during the push time it was pushed together inside normal stack and min stack.
        }
        st.pop();//normal case of popping
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return minSt.peek();
    }    
}
