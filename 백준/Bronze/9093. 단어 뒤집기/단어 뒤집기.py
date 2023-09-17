T = int(input())
for _ in range(T):
    res = []
    s = input()
    lis = list(s.split())
    for i in lis:
        res.append(i[::-1])
    print(' '.join(res))


