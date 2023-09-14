# [Bronze II] 팰린드롬인지 확인하기 - 10988 

[문제 링크](https://www.acmicpc.net/problem/10988) 

### 성능 요약

메모리: 31256 KB, 시간: 40 ms

### 분류

구현, 문자열

### 문제 설명

<p>알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.</p>

<p>팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. </p>

<p>level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.</p>

### 입력 

 <p>첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.</p>

### 출력 

 <p>첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.</p>


   ---

### 🤔 key point

#### / 와 //
/와 //는 둘 다 몫을 구해주는 연산자이다. /는 소수점까지 나타내고, //는 정수로만 몫을 나타낸다.
```python3
print(5/2)  # 출력 : 2.5
print(5//2) # 출력 : 2
```
### 문자열 뒤집기
파이썬에서 문자열을 거꾸로 뒤집고 싶을 때 사용할 수 있는 방법

#### "".join(reversed(문자열))

```python3
s = 'codesooo'
re_s = "".join(reversed(s))
print(re_s)
# 출력 : ooosedoc
```

#### 슬라이싱
문자열 슬라이싱을 이용한다. `문자열[시작:끝:규칙]`이므로 규칙 자리에 -1이 들어가면 마지막 글자부터 순서대로 출력해주는 것이다.
```python3
s = 'codesooo'
print(s[::-1])
# 출력 : ooosedoc
```

#### list로 변환하여 뒤집기
list 타입에서 제공하는 함수인 reverse()는 list 내의 요소를 역순으로 정렬해준다. 따라서 문자열을 list로 변환하여 reverse()를 적용해주면 된다. 그리고 문자열로 출력하고 싶다면 join함수를 이용하여 `list->문자열`로 변환해주면 된다.
```python3
s = 'codesooo'
s_list = list(s)
s_list.reverse()
print(s_list)           # 출력 : ['o', 'o', 'o', 's', 'e', 'd', 'o', 'c']
print("".join(s_list))  # 출력 : ooosedoc
```

---
### 👩‍💻 수정한 코드
```python3
s = input()
re_s = "".join(reversed(s))
if s == re_s :
    print(1)
else:
    print(0)
```
