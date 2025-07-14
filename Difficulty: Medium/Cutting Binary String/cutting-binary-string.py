class Solution:
    powers_of_5=set()
    
    @classmethod
    def precompute_powers(cls):
        if cls.powers_of_5:
            return
        x=1
        while True:
            bin_str=bin(x)[2:]
            if len(bin_str)>30:
                break
            cls.powers_of_5.add(bin_str)
            x*=5
    
    def cuts(self, s):
        self.__class__.precompute_powers()
        n=len(s)
        dp=[float("inf")]*(n+1)
        dp[0]=0
        for i in range(1,n+1):
            for j in range(i):
                sub_str=s[j:i]
                if sub_str[0]!="0" and sub_str in self.__class__.powers_of_5:
                    dp[i]=min(dp[i],1+dp[j])
        return dp[n] if dp[n]!=float("inf") else -1