n = int(input())

plus = [] #양수 들 담을거임
minus = [] # 음수들 담을거임

ans = 0
for i in range(n):
    num = int(input())
    if num > 1:
        plus.append(num)
    elif num <= 0:
        minus.append(num)
    else:
        ans += num

plus.sort(reverse=True)
minus.sort()

# 양수 묶기
for i in range(0, len(plus), 2):
    if i+1 >= len(plus):
        ans += plus[i]
    else:
        ans += (plus[i] * plus[i+1])

# 음수 묶기
for i in range(0, len(minus), 2):
    if i+1 >= len(minus):
        ans += minus[i]
    else:
        ans += (minus[i] * minus[i+1])

print(ans)