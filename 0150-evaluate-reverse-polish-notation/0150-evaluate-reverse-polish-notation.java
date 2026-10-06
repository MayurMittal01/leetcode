class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            }
            else if (s.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            }
            else if (s.equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            }
            else if (s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}