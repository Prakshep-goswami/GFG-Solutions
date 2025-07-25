class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int n = arr.length;
        
       
        int maxKadane = kadane(arr);
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; 
        }

        int maxInvertedKadane = kadane(arr); 
        int maxWrap = totalSum + maxInvertedKadane; 
      
        if (maxWrap == 0) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, maxWrap);
    }
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
        
    }
}