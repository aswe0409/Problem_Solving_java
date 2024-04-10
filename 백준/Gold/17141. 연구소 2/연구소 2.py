def implant(n, m):
    global result
    if m == M: # M개를 뽑아서
        time = spread() # 그때 시간 중에
        result = min(result, time) # 최소 저장
        return

    else :
        for i in range(n, N*N):
            r, c = i//N, i%N
            if lab[r][c] == 2:
                lab[r][c] = 3
                implant(i, m+1)
                lab[r][c] = 2

def spread():
    visited = [[0]*N for _ in range(N)]
    queue = deque()
    time = 0

    for i in range(N):
        for j in range(N):
            if lab[i][j] == 3: # 바이러스 심을 위치에
                visited[i][j] = 1 # 방문 처리후
                queue.append([i,j]) # 심자

    while queue:
        y, x = queue.popleft()
        for dy, dx in move:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and lab[ny][nx] != 1:
                visited[ny][nx] = visited[y][x] + 1 # 퍼뜨려보고
                queue.append([ny,nx])
                time = max(time, visited[ny][nx]) -1 #그 때 최대값

    for i in range(N):
        for j in range(N):
            if not visited[i][j] and lab[i][j] != 1: # 방문 안한 곳이 벽도 아니라면
                return float('inf') # 무한대 반환(나중에 최소 값 비교를 위함)
    return time

import sys
from collections import deque
N, M = map(int, sys.stdin.readline().split())
lab = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
move = [[0,1],[0,-1],[1,0],[-1,0]]
result = float('inf')
implant(0,0)
if result == float('inf'):
    result = -1
print(result)
#출처: https://edder773.tistory.com/274 [개발하는 차리의 공부 일기:티스토리]