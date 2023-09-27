X, Y, W, S = map(int, input().split())

res1 = (X+Y) * W

if(X + Y) % 2 == 0:
    res2 = max(X,Y) * S
else:
    res2 = (max(X,Y) - 1) * S + W

res3 = min(X,Y) * S + abs(X-Y) * W
print(min(res1,res2,res3))