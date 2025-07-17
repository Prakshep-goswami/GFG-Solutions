import math

class Solution:
    def isPrime(self, n: int) -> bool:
        return n > 1 and all(n % i for i in range(2, int(math.sqrt(n)) + 1))

    def factors(self, k: int) -> list[int]:
        return [i for i in range(2, k + 1) if k % i == 0 and self.isPrime(i)]

    def maxKPower(self, N: int, K: int) -> int:
        primes = self.factors(K)
        cnt_f = [0] * len(primes)
        for i, p in enumerate(primes):
            num = N
            while num:
                num //= p
                cnt_f[i] += num

        cnt_k = [0] * len(primes)
        num = K
        for i, p in enumerate(primes):
            while num % p == 0:
                num //= p
                cnt_k[i] += 1

        return min(c // k for c, k in zip(cnt_f, cnt_k)) if all(cnt_k) else 0