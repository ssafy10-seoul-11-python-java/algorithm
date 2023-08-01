import heapq
 
 
class Tunnel:
    def __init__(self, v1, v2, dist):
        self.v1 = v1;
        self.v2 = v2;
        self.dist = dist
 
    def __lt__(self, other):
        if isinstance(other, Tunnel):
            return self.dist < other.dist
 
    def getVar(self):
        return (self.v1, self.v2, self.dist)
 
    def return1(self):
        return 1
 
 
class Island:
    def __init__(self, n):
        self.x = []
        self.y = []
        self.union = [i for i in range(n)]
 
    def getDist(self, v1, v2):
        return ((self.x[i] - self.x[j]) ** 2) + ((self.y[i] - self.y[j]) ** 2)
 
    def find_union(self,idx):
        if self.union[idx] != idx:
            self.union[idx] = self.find_union(self.union[idx]);
        return self.union[idx]
 
 
T = int(input())
 
for test_case in range(1, T + 1):
    n = int(input())
    island = Island(n)
    island.x = list(map(int, input().split()))
    island.y = list(map(int, input().split()))
    e = float(input())
 
    pq = []
 
    for i in range(n):
        for j in range(i + 1, n):
            t = Tunnel(i, j, 10)
            heapq.heappush(pq, Tunnel(i, j, island.getDist(i, j)))
 
    total_dist = 0
    while pq:
        v1, v2, dist = heapq.heappop(pq).getVar()
        v1_union = island.find_union(island.union[v1])
        v2_union = island.find_union(island.union[v2])
        if v1_union < v2_union:
            island.union[v2_union] = v1_union
            total_dist += dist
        elif v1_union > v2_union:
            island.union[v1_union] = v2_union
            total_dist += dist
    print(f"#{test_case} {round(total_dist * e)}")
