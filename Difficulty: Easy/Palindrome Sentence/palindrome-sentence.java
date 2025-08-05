class Solution {
    public boolean isPalinSent(String s) {
        // code here
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        
        StringBuffer sb=new StringBuffer(cleanString);
        
        sb.reverse();
        
        String newString=sb.toString();
        
        if(cleanString.equals(newString) ){
            return true;
        }else{
            return false;
        }
    }
}

