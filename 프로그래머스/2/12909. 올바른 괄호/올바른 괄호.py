def solution(s):
    stack = []
    for i in s:
        if i == ')':
            if len(stack)!=0 and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(i)    
        else:
            stack.append(i)
    if len(stack) == 0:
        return True
    else:
        return False
        
                
            