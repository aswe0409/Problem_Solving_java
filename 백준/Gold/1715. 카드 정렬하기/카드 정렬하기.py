import heapq

n = int(input())
arr = [int(input()) for _ in range(n)]
ret = []

if len(arr) == 1:
    print(0)
    quit()
elif len(arr) == 2:
    print(arr[0] + arr[1])
    quit()
    
else:
    heapq.heapify(arr)
    for i in range(n-1):
        a = heapq.heappop(arr)
        b = heapq.heappop(arr)
        temp = a+b
        heapq.heappush(arr, temp)
        ret.append(temp)
    print(sum(ret))