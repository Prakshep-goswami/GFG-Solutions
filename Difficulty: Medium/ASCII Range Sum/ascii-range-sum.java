class Solution {
    public ArrayList<Integer> asciirange(String s) {
      Map<Character, int[]> map = new HashMap<>();

        // First pass: record start and end index of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{i, i}); // start and end same initially
            } else {
                map.get(ch)[1] = i; // update end
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Second pass: for each character, if start != end, calculate ASCII sum in between
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int start = entry.getValue()[0];
            int end = entry.getValue()[1];

            if (end - start <= 1) continue; // no characters strictly between

            int sum = 0;
            for (int i = start + 1; i < end; i++) {
                sum += s.charAt(i);
            }

            if (sum > 0) result.add(sum);
        }

        return result;
    }
}