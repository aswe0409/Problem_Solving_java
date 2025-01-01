n = int(input())
cnt = 0

for _ in range(n):
    arr = []
    s = list(input())
    for i in range(len(s)):
        if arr:
            if s[i] == arr[-1]:
                arr.pop()
            else:
                arr.append(s[i])
        else:
            arr.append(s[i])
            
    if not arr:
        cnt +=1
print(cnt)