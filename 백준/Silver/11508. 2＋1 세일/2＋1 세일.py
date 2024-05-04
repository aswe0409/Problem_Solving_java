from collections import deque

n = int(input())
arr = deque(sorted([int(input()) for _ in range(n)], reverse=True))
ret = 0

while len(arr) >= 3:
    ret += arr[0] + arr[1]
    arr.popleft()
    arr.popleft()
    arr.popleft()

while arr:
    ret += arr.popleft()

print(ret)