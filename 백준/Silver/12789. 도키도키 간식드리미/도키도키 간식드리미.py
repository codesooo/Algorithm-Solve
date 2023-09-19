N = int(input())
lineNum = list(map(int, input().split()))
get = []
wait = []
i = 0
while i < len(lineNum):
    if lineNum[i] == len(get)+1:
        get.append(lineNum[i])
    elif len(wait) != 0 and wait[-1]==len(get)+1:
        get.append(wait.pop())
        i -= 1
    else:
        wait.append(lineNum[i])
    i +=1

for j in wait[::-1]:
    get.append(j)
if get == sorted(get):
    print("Nice")
else:
    print("Sad")