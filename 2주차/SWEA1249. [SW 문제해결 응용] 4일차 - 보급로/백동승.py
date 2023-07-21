import heapq

class Node:
    def __init__(self, y, x, t):
        self.y = y; self.x = x; self.t = t
    def __lt__(self, other):
        if isinstance(other, Node):
            return self.t < other.t
    def getVar(self):
        return (self.y, self.x, self.t)

    
T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    board = [[-1 for j in range(n+2)]]
    for i in range(n):
        board.append([-1] + [int(j) for j in input()] + [-1])
    board.append([-1 for j in range(n+2)])

    heap = [Node(1,1,0)]
    delta = [(0,1),(0,-1),(1,0),(-1,0)]
    result = 0
    
    while heap:
        y, x, t = heapq.heappop(heap).getVar()
        if (y, x) == (n, n):
            result = t
            break
        
        board[y][x] = -1
        for off_y, off_x in delta:
            nxt_y = y + off_y
            nxt_x = x + off_x
            nxt_t = board[nxt_y][nxt_x]
            if nxt_t != -1:
                nxt_t += t
                heapq.heappush(heap, Node(nxt_y, nxt_x, nxt_t))
    print(f"#{test_case} {result}")
