def solve(people):
    N = len(people)
    answer = [[0 for _ in range(N)] for _ in range(16)]
    for day in range(N):
        must = 1
        if people[day] == 'A':
            # 8
            must = 0b1000
        elif people[day] == 'B':
            # 4
            must = 0b100
        elif people[day] =='C':
            # 2
            must = 0b10

        if day == 0:
            for today in range(16):
                if (today & must) != 0b0 and (today & 0b1000) != 0b0:
                    answer[today][day] = 1
            continue

        # before , today : 전날 나온 사람 번호
        for before in range(16):
            for today in range(16):
                if answer[before][day-1] == 0:
                    continue
                # 전날 나온 사람이 오늘도 나와야 함 , 당일 책임지는 사람이 있는지
                if ((today & must) != 0b0) and ((before & today) != 0b0):
                    # print("가능")
                    answer[today][day] += answer[before][day-1]
                    answer[today][day] %= 1000000007
    ans = 0
    for i in answer:
        ans += i[len(people)-1]
    return ans


T = int(input())

for i in range(T):
    people = input()
    answer =solve(people)  % 1000000007
    print("#" , i +1 ," " , answer, sep='')





