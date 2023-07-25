from collections import deque
def min_root():
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    keys = [[99999] * N for _ in range(N)]
    keys[0][0] = 0  # 시작점은 0
    q = deque()
    q.append((0, 0))
 
    while q:
        x, y = q.popleft()
 
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
 
            if 0 <= nx < N and 0 <= ny < N:
                # 현재 지점의 값 + 다음 지점을 가는데 필요한 값 < 다음 지점의 값
                # 을 비교한다.
                if keys[x][y] + N_arr[nx][ny] < keys[nx][ny]:
                    keys[nx][ny] = keys[x][y] + N_arr[nx][ny]
                    q.append((nx, ny))
 
    answer = keys[-1][-1]
    return answer
 
T =int(input())
 
for loop in range(1,T+1):
    N = int(input())
    N_arr = [list(map(int, list(input()))) for _ in range(N)]
 
    print(f'#{loop} {min_root()}')
