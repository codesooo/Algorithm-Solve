import sys


K = int(sys.stdin.readline())
cog = []
sum = 0

def ckeck(n):
    if n == 0:
        cog.pop()
    else:
        cog.append(n)


for _ in range(K):
    n = int(sys.stdin.readline())
    ckeck(n)

for i in cog:
    sum += i

print(sum)
