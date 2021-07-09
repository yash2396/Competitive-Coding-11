// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        HashSet<String> set = new HashSet(Arrays.asList("+","-","*","/"));
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < tokens.length ; i++){
            String c = tokens[i];
            if(set.contains(c)){
                int op2 = st.pop();
                int op1 = st.pop();
                if(c.equals("+")) st.push((op1+op2));
                if(c.equals("-")) st.push((op1-op2));
                if(c.equals("*")) st.push((op1*op2));
                if(c.equals("/")) st.push((op1/op2));
            }
            else st.push(Integer.valueOf(c));
        }
        return st.pop();
    }
}
