# Project Euler

# Problem 3: Largest prime factor

# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?

import math

N = 600851475143 # ~600 billion

# Note there are several billions of primes less than N. Not feasible to consider them all.

# We're making use of the following facts:
# 1. (Fundamental theorem of arithmetic) Every integer has a prime factorization and it is unique up to the order of the prime factors.
# 2. Every composite number has a factor less than or equal to its square root.
# 3. The smallest factor of an integer is prime.

# Approach: keep dividing out the smallest factor of N (which is prime). What you'll end up with is the largest prime factor.

primes = []

# find the smallest prime factor of n >= 2
def smallestPrimeFactor(n):
    for i in range(2, int(math.sqrt(n) + 1)): # fact 2
        if n % i == 0:
            return i # first factor found is the one we want
    return n # n itself is prime

n = N

while True:
    p = smallestPrimeFactor(n)
    print(p)
    if p < n:
        n = n // p # integer division
    else:
        # smallest factor is the number itself -> this is the largest prime factor of N
        print("DONE. Answer is:", n)
        break


