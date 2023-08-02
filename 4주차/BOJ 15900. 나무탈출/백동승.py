import sys
input = sys.stdin.readline

n = int(input())

nodes = [[] for i in range(n + 1)]
is_odd = [False for i in range(n + 1)]

for i in range(n - 1):
    a, b = map(int, input().split())
    nodes[a].append(b)
    nodes[b].append(a)

win = False
q = [(1, 0)]

while q:
    cur, parent = q.pop()
    if len(nodes[cur]) == 1 and is_odd[cur]:
        win = not win

    for nxt in nodes[cur]:
        if nxt == parent:
            continue
        is_odd[nxt] = not is_odd[cur]
        q.append((nxt, cur))

if win:
    print("Yes")
else:
    print("No")
