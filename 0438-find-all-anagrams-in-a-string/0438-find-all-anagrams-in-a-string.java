class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (right - left + 1 > p.length()) {

                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                left++;
            }

            if (windowMap.equals(pMap)) {
                result.add(left);
            }
        }

        return result;
    }
}