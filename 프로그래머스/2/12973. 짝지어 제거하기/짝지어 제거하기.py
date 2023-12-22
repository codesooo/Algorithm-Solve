def solution(s) :
    stack = []

    for value in s :
        if not stack :
            stack.append(value)
        else :
            if stack[-1] == value :
                stack.pop()
            else :
                stack.append(value)

    if stack :
        return 0

    return 1