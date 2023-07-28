import heapq

n, m = map(int, input().split())
cards = list(map(int, input().split()))

if n == 2:
    print((cards[0]+cards[1]) << m)

else:
    heapq.heapify(cards)
    for i in range(m):
        a = cards[0]
        a += min(cards[1],cards[2])
        heapq.heappushpop(cards,a)
        heapq.heappushpop(cards,a)

    print(sum(cards))
