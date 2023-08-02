import heapq


class Node:
    def __init__(self, idx, cnt):
        self.idx = idx
        self.cnt = cnt

    def __lt__(self, other):
        if isinstance(other, Node):
            return self.cnt < other.cnt

    def get_var(self):
        return self.idx, self.cnt


def search():
    heap = [Node(1, 0)]
    dp[1] = 0
    while heap:
        idx, cnt = heapq.heappop(heap).get_var()
        for nxt in range(idx+1, idx+7):
            if nxt == 100:
                return cnt+1

            if bridge[nxt]:
                nxt = bridge[nxt]

            if dp[nxt] <= cnt+1:
                continue

            dp[nxt] = cnt+1
            heapq.heappush(heap, Node(nxt, cnt + 1))


n, m = map(int, input().split())
bridge = [0 for i in range(101)]
dp = [200 for i in range(101)]

for i in range(n+m):
    start, end = map(int, input().split())
    bridge[start] = end

print(search())
