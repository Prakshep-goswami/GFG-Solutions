class Solution:
    def countNumbers(self, n):
        # prakshep goswami
        
        limit = int(math.sqrt(n))+1
        primes = [1]*(limit)
        primes[0] = primes[1] = 0
        for i in range(2, limit):
            if primes[i]:
                for j in range(2*i, limit, i):
                    primes[j] = 0
        p = [e for e in range(limit) if primes[e]]
        i, j = 0, len(p)-1
        ans = 0
        limit -= 1
        #print(p)
        while i<j:
            #print(i, j, ans)
            if p[i]*p[j]<=limit:
                ans+=j-i
                i+=1
            else:
                j-=1
        for i in range(2, 14):
            if i in p and i**8<n:
                ans+=1
        return ans