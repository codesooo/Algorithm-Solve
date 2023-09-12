# import sys 

# stack = []
# def Command(s):
    
#     if len(s) == 1:
#         if s == '2':
#             if len(stack) != 0:
#                     return stack.pop()
#             else:
#                 return -1
#         elif s == '3':
#             return len(stack)
#         elif s == '4':
#             if len(stack) == 0:
#                 return 1
#             else:
#                 return 0
#         elif s == '5':
#             if len(stack) != 0:
#                 return stack[-1]
#             else:
#                 return -1
#     else:
#         stack.append(int(s[-1]))
#         return

# N = int(sys.stdin.readline())
# for _ in range(N):
#     s = (sys.stdin.readline())[:-1]
#     res = Command(s)
#     if res != None:
#         print(res)

import sys 

stack = []
def Command(s):
    if s[0] == 1:
        stack.append(s[1])
    elif s[0] == 2:
        if len(stack) != 0:
            return stack.pop()
        else:
            return -1
    elif s[0] == 3:
        return len(stack)
    elif s[0] == 4:
        if len(stack) == 0:
            return 1
        else:
            return 0
    elif s[0] == 5:
        if len(stack) != 0:
            return stack[-1]
        else:
            return -1
    

N = int(sys.stdin.readline())
for _ in range(N):
    s = list(map(int,sys.stdin.readline().split()))
    res = Command(s)
    if res != None:
        print(res)
