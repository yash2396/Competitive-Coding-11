// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || num.length() == k) return "0";
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < num.length() ;i++){
            char x = num.charAt(i);
            while(!st.isEmpty() && st.peek() > x && k > 0){
                st.pop();
                k--;
            }
            st.push(x);
        }
        for(int i = 0 ; i < k ; i++) st.pop();
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        while(result.length() > 0 && result.charAt(result.length()-1) == '0')
            result.replace(result.length()-1,result.length(),"");
        if(result.length() == 0) return "0";
        return result.reverse().toString();       
    }
}
