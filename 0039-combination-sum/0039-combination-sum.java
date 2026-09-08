class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    void backtrack(int[] candidates, int index,
                   int remaining, List<Integer> current) {

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);

            backtrack(candidates, i,
                      remaining - candidates[i], current); 

            current.remove(current.size() - 1); 
        }
    }
}