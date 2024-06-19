import heapq
import sys

n, m = map(int, sys.stdin.readline().split())

arr = []
arr += map(int, sys.stdin.readline().split())
heapq.heapify(arr)

for _ in range(m):
    n1 = heapq.heappop(arr)
    n2 = heapq.heappop(arr)
    temp = n1 + n2
    heapq.heappush(arr, temp)
    heapq.heappush(arr, temp)
    
print(sum(arr))