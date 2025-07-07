class Solution:
    def nextLargerElement(self, arr):
        st=[]
        n=len(arr)
        li=[-1]*n
        for i in range((2*n)-1,-1,-1):
            while len(st)>0 and st[len(st)-1]<=arr[i%n]:
                st.pop()
            if i<n and len(st)>0:
                    li[i]=st[len(st)-1]
            st.append(arr[i%n])
        return li