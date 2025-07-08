from collections import Counter
class Solution:
    def findGreater(self, arr):
        count=Counter(arr)
        op=[-1]*len(arr)
        stack=[]
        for i in range(len(arr)-1,-1,-1):
            while stack and count[stack[-1]]<=count[arr[i]]:
                stack.pop()
            if not stack:
                stack.append(arr[i])
            else:
                op[i]=stack[-1]
                stack.append(arr[i])
        return op