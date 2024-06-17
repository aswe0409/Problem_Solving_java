n = int(input())
k = int(input())
arr = sorted(list(map(int, input().split())))
diff = []

for i in range(len(arr) -1):
    diff.append(arr[i+1] - arr[i])
    
diff.sort()
ans = 0
for i in range(len(diff) - k+1 ):
    ans += diff[i]
print(ans)