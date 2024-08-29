import sys
from collections import deque

input = sys.stdin.readline


N, W, L = map(int, input().split()) 
arr = list(map(int, input().split()))  
bridge = deque([0] * W) 
time = 0  # 총 시간
temp_weight = 0  # 현재 다리 위에 있는 트럭의 총 무게
idx = 0  # 트럭의 인덱스

while True:
    time += 1  # 시간 경과
    
    # 다리에서 트럭 이동
    temp_weight -= bridge.popleft() 
    
    # 다리에 새로운 트럭을 올릴 수 있는지 확인
    if idx < N and temp_weight + arr[idx] <= L and len(bridge) < W:

        bridge.append(arr[idx])
        temp_weight += arr[idx]
        idx += 1
    else:
        bridge.append(0)
    
    
    if idx == N and temp_weight == 0:
        print(time)
        break