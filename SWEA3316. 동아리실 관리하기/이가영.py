MOD = 1000000007

def calculate(schedule):
    dic = {"A": 0b0001, "B": 0b0010, "C": 0b0100, "D": 0b1000}
    N = len(schedule)
    dp = [[0] * 16 for _ in range(N)]


    for day in range(0, N):
        master = dic[schedule[day]]
        for bit in range(1,16):
            if day == 0: #첫날 계산
                if (bit & master) != 0 and (bit & 1) != 0: # 첫날 A가 있는지 관리자가 있는지 확인
                    dp[day][bit] = 1; # 있다면 1로 할당


            else :
                if(dp[day-1][bit]!=0):
                    for j in range(1,16):
                        if (bit & j) != 0 and (j & master) != 0: # 전날과 겹치는 사람 없는지, 관리자가 있는지 확인
                            dp[day][j] =(dp[day][j] + dp[day-1][bit]) % MOD;

    result = sum(dp[N - 1][1:]) % MOD
    return result

# 테스트 케이스 입력 받기
T = int(input())

for tc in range(1, T + 1):
    schedule = input()
    result = calculate(schedule)
    print(f"#{tc} {result}")
