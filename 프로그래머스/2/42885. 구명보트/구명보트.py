from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()
    people = deque(people)

    while people:
        if len(people) == 1:
            answer += 1
            break

        elif people[0] + people[-1] <= limit:
            answer += 1
            people.pop()
            people.popleft()
        else:
            answer += 1
            people.pop()

    return answer