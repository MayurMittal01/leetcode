class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, "", result);
        return result;
    }

    private void backtrack(int open, int close, String current, List<String> result) {

        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }

        if (open > 0) {
            backtrack(open - 1, close, current + "(", result);
        }

        if (close > open) {
            backtrack(open, close - 1, current + ")", result);
        }
    }
}