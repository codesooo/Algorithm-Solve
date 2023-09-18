S = input()

res = set()

for i in range(len(S)):
    for j in range(i+1, len(S)+1):
        res.add(S[i:j])
print(len(res))