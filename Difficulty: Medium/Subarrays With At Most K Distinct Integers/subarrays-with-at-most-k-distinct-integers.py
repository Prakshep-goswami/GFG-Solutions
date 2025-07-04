from collections import defaultdict
class Solution:
    def countAtMostK(self, arr, k):
        # Code here
        mp=defaultdict(int)
        ans=0
        j=0
        for i in range(len(arr)):
            mp[arr[i]]+=1
            while len(mp)>k and j<len(arr):
                mp[arr[j]]-=1
                if mp[arr[j]]==0:
                    del mp[arr[j]]
                j+=1
            ans+=(i-j+1)
        return ans