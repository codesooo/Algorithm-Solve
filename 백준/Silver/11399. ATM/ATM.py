time = 0
restime = 0

people_num = int(input())
runtime = list(map(int, input().split()))
runtime.sort()

for i in runtime:
    time += i
    restime += time
print(restime)