class Solution:
    def cntSubarrays(self, arr, k):
        # code here
        count = 0
        curr_sum = 0
        prefix_sum_map = {0: 1} 

        for num in arr:
            curr_sum += num
            if (curr_sum - k) in prefix_sum_map:
                count += prefix_sum_map[curr_sum - k]
            prefix_sum_map[curr_sum] = prefix_sum_map.get(curr_sum, 0) + 1

        return count