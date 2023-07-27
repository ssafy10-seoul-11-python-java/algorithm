import heapq

n, m = map(int, input().split())
cards = list(map(int, input().split()))

if n == 2:
    print((cards[0]+cards[1]) << m)

else:
    heapq.heapify(cards)
    for i in range(m):
        a = heapq.heappop(cards)
        a += heapq.heappop(cards)
        heapq.heappush(cards, a)
        heapq.heappush(cards, a)

    print(sum(cards))
