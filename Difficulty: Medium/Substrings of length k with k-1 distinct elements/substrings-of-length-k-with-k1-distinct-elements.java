class Solution {
    public int substrCount(String s, int k) {
     
        int count = 0;
        
        for(int i=0; i<=s.length()-k; i++) {
            String currString = s.substring(i, i+k);
            
            if(isSubstr(currString, k)) count++;
        }
        
        return count;
    }
    
    private boolean isSubstr(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        if(set.size() == k-1) return true;
        
        return false;
    }
}

