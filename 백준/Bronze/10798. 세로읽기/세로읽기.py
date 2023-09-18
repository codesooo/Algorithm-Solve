import sys

lis = []
res = []
n = []
for _ in range(5):
    s = list(sys.stdin.readline()[:-1])
    lis.append(s)

for l in range(5):
    n.append(len(lis[l]))

for i in range(max(n)):
    for j in range(5):
        try:
            res.append(lis[j][i])
        except:
            pass
print(''.join(res))
